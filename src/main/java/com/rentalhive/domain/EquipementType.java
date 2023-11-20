package com.rentalhive.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EquipementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private  Equipement equipement;
    @NotBlank
    private String Matricul ;
    @OneToMany(mappedBy = "equipementType")
    Set <EquipementTypeReservation> equipementTypeReservations;
}
