package com.rentalhive.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ReservationEquipmentDto {
    // create reservation user id  id de resrvation  status en attuent
    @NotBlank
    private Long  id_user;
    @NotBlank
    private String nameEquipment;
    @NotBlank
    private LocalDateTime dateStartReservation;
    @NotBlank
    private LocalDateTime dateRetoure;
    @NotBlank
    private Integer quantite ;
}
