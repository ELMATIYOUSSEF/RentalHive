package com.rentalhive.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private Integer quantite ;
    @NotBlank
    private Double cout_Location;
    @OneToMany(mappedBy = "equipment",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EquipmentType> equipmentTypes;

}
