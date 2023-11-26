package com.rentalhive.DTO;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.rentalhive.domain.Devis;
import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.domain.enums.DevisStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;



@Builder
public class DevisDTO {
    @OneToMany
    private List<EquipmentItemsReservation> equipmentItemsReservations;
    @NotNull(message = "DevisStatus must be Accepted or Denied or Pending")
    private DevisStatus status;
    @NotBlank(message = "You must enter conditional terms")
    private String terms;

    public Devis DTOtoDevis(){
        return Devis.builder()
                .terms(terms)
                .status(status)
                .equipmentItemsReservations(equipmentItemsReservations)
                .build();
    }
}
