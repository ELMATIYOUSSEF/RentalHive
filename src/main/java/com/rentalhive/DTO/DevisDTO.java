package com.rentalhive.DTO;

import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.domain.enums.DevisStatus;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class DevisDTO {
    @OneToMany
    private List<EquipmentItemsReservation> equipmentItemsReservations;
    @NotNull(message = "DevisStatus must be Accepted or Denied or Pending")
    private DevisStatus status;
    @NotBlank(message = "You must enter conditional terms")
    private String terms;

}
