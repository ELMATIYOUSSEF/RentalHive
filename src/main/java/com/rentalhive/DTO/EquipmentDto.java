package com.rentalhive.DTO;

import com.rentalhive.domain.enums.StatusEquipmentItems;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EquipmentDto {

    @NotBlank
    private String name;
    @NotBlank
    private Integer quantite ;
    @NotBlank
    private Double cout_Location;
    @NotBlank
    private String Matricul ;
    @NotBlank
    private StatusEquipmentItems statusEquipementType;
}
