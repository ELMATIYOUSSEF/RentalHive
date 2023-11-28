package com.rentalhive.web.rest;

import com.rentalhive.DTO.DevisDTO;
import com.rentalhive.DTO.DevisInfoDTO;
import com.rentalhive.domain.Devis;
import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.service.impl.DevisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/devis")
public class DevisController {
    @Autowired
    private DevisServiceImpl devisService;

    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> addDevis (@Valid @RequestBody DevisDTO devisDTO, BindingResult bindingResult){
        Map<String, Object> response = new HashMap<>();
        if (bindingResult.hasErrors()){
            response.put("status","Error");
            response.put("message","ValidationError");
            Map<String , String> errors = new HashMap<>();
            for (ObjectError error : bindingResult.getAllErrors()){
                errors.put(error.getObjectName(),error.getDefaultMessage());
            }
            response.put("errors",errors);
            return ResponseEntity.badRequest().body(response);
        }

        Devis devis = new Devis();
        devis.setStatus(devisDTO.DTOtoDevis().getStatus());
        devis.setTerms(devisDTO.DTOtoDevis().getTerms());
        devis.setEquipmentItemsReservations(devisDTO.DTOtoDevis().getEquipmentItemsReservations());


        List<DevisInfoDTO> test = new ArrayList<>();
        List<EquipmentItemsReservation> equipmentItemsReservations = devis.getEquipmentItemsReservations();
        for (EquipmentItemsReservation reservation : equipmentItemsReservations){
            Long idR = reservation.getId();
            DevisInfoDTO devisInfoDTO = devisService.getEquipmentInfo(idR);
            test.add(devisInfoDTO);
        }
        Devis devis1 = devisService.addDevis(devis);
        response.put("status","Success");
        response.put("message","DevisAddedSuccessfully");
        response.put("Devis", devis1.devisToDTO());
        response.put("Equipments",test);
        return ResponseEntity.ok(response);
    }
}
