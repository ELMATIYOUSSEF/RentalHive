package com.rentalhive.web.rest;

import com.rentalhive.DTO.ReservationEquipmentDto;
import com.rentalhive.domain.*;
import com.rentalhive.domain.enums.StatusReservation;
import com.rentalhive.service.EquipmentItemsService;
import com.rentalhive.service.ReservationService;
import com.rentalhive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final UserService userService;
    private final EquipmentItemsService equipmentItemsService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEquipment(@RequestBody ReservationEquipmentDto reservationDto)  {
        try {
            Map<String, Object> response = new HashMap<>();
            // ExpiredDate
            ExpiredDate(reservationDto.getDateStartReservation() ,  response );
            // checkQuantity
            List<EquipmentItem> equipmentItems = checkQuantity(reservationDto.getQuantite(),reservationDto.getNameEquipment(), reservationDto.getDateStartReservation(),reservationDto.getDateRetoure());
            if (equipmentItems != null){
                List<EquipmentItem> equipmentTypesReserve = equipmentItems.stream()
                        .limit(reservationDto.getQuantite())
                        .toList();
               //get user
               User user = userService.findById(reservationDto.getId_user());
               Reservation reservation = Reservation.builder()
                       .user(user)
                       .statusReservation(StatusReservation.pending)
                       .build();
               Reservation SavedReservation = reservationService.saveReservation(reservation);
                for (EquipmentItem equipmentItem1 : equipmentTypesReserve) {
                    // create EquipmentItemsReservation
                    EquipmentItemsReservation equipementItemReservation = EquipmentItemsReservation.builder()
                            .dateReservation(reservationDto.getDateStartReservation())
                            .dateRetoure(reservationDto.getDateRetoure())
                            .reservation(SavedReservation)
                            .equipmentItem(equipmentItem1)
                            .build();
                    reservationService.reservationEquipment(equipementItemReservation);
                }
               return ResponseEntity.ok().body(SavedReservation);
           }
           else{
               response.put("status", "Error");
               response.put("message", "This Quantity not available");
               return ResponseEntity.ok(response);
           }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    public List<EquipmentItem> checkQuantity(Integer Qnt, String nameEquipment, LocalDateTime dateStart, LocalDateTime dateRouter) {
        List<EquipmentItem> equipmentTypesInStock = reservationService.findAvailableEquipementTypes(dateStart,dateRouter);
        List<EquipmentItem> equipmentItems = equipmentTypesInStock.stream()
                .filter(equipementTypeReservation -> nameEquipment.equals(equipementTypeReservation.getEquipement().getName()))
                .toList();

        if (equipmentItems.size() >= Qnt)
            return equipmentItems;

        return null;
    }


    public void ExpiredDate(LocalDateTime dateTime , Map<String, Object> response ){
        if(dateTime.isBefore(LocalDateTime.now())) {
            response.put("status", "Error");
            response.put("message", "This Date is Expired");
            ResponseEntity.ok(response);
        }
    }
}
