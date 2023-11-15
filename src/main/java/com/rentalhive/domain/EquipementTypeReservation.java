package com.rentalhive.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EquipementTypeReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private EquipementType equipementType;
    @ManyToOne
    private Reservation reservation;
    @NotBlank
    private LocalDateTime dateReservation;
    @NotBlank
    private LocalDateTime dateRetoure;
    @NotBlank
    private Integer quantite ;

}
