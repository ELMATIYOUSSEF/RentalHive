package com.rentalhive.domain;

import com.rentalhive.DTO.EquipmentItemsReservationDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EquipmentItemsReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private EquipmentItem equipmentItem;
    @ManyToOne
    private Reservation reservation;
    @NotBlank
    private LocalDateTime dateReservation;
    @NotBlank
    private LocalDateTime dateRetoure;

    public EquipmentItemsReservationDTO MapTOItemsDTO(){
        return EquipmentItemsReservationDTO.builder()
                .dateReservation(dateReservation)
                .dateRetoure(dateRetoure)
                .equipmentItem(equipmentItem)
                .build();
    }

}
