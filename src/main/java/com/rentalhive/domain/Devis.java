package com.rentalhive.domain;
import com.rentalhive.DTO.DevisDTO;
import com.rentalhive.domain.enums.DevisStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<EquipmentItemsReservation> equipmentItemsReservations;
    private DevisStatus status;
    private String terms;
    public DevisDTO devisToDTO(){
        return DevisDTO.builder()
                .terms(terms)
                .equipmentItemsReservations(equipmentItemsReservations)
                .status(status)
                .build();
    }
}
