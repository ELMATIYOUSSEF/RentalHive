package com.rentalhive.domain;
import com.rentalhive.domain.enums.DevisStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<EquipmentItemsReservation> equipmentItemsReservations;
    private DevisStatus status;
    private String terms;
}
