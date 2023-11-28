package com.rentalhive.DTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rentalhive.domain.Devis;
import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.domain.enums.StatusEquipmentItems;
import com.rentalhive.domain.enums.StatusReservation;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Builder
@Data
@JsonSerialize
public class DevisInfoDTO {
    @NotBlank
    private String name;
    @NotBlank
    private Double cout_Location;
    @NotBlank
    private String Matricul ;

    private String email ;

    @NotBlank
    private LocalDateTime dateReservation;
    @NotBlank
    private LocalDateTime dateRetoure;
    public static DevisInfoDTO fromEquipmentItemsReservationToDTO(EquipmentItemsReservation equipmentItemsReservation){
        return DevisInfoDTO.builder()
                .name(equipmentItemsReservation.getEquipmentItem().getEquipment().getName())
                .Matricul(equipmentItemsReservation.getEquipmentItem().getMatricul())
                .cout_Location(equipmentItemsReservation.getEquipmentItem().getEquipment().getCout_Location())
                .email(equipmentItemsReservation.getReservation().getUser().getEmail())
                .dateReservation(equipmentItemsReservation.getDateReservation())
                .dateRetoure(equipmentItemsReservation.getDateRetoure())
                .build();
    }
}
