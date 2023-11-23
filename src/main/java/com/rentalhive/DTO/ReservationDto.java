package com.rentalhive.DTO;

import com.rentalhive.domain.enums.StatusReservation;
import lombok.*;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ReservationDto {
    @NotBlank
    private Long  id_user;
    @NotBlank
    private StatusReservation statusReservation;
}
