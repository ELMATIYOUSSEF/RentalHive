package com.rentalhive.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EquipmentItemsDto {
    @NotBlank
    private String equipementname;
    @NotBlank
    private String matricul ;
}
