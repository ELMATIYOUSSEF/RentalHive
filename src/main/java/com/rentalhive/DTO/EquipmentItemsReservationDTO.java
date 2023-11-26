package com.rentalhive.DTO;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.domain.Reservation;
import lombok.Builder;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Builder
public class EquipmentItemsReservationDTO {
    private EquipmentItem equipmentItem;
    private Reservation reservation;

    private LocalDateTime dateReservation;
    private LocalDateTime dateRetoure;

    public EquipmentItemsReservation MapTOItems(){
        return EquipmentItemsReservation.builder()
                .dateReservation(dateReservation)
                .dateRetoure(dateRetoure)
                .equipmentItem(equipmentItem)
                .build();
    }
}
