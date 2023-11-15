package com.rentalhive.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
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
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private Integer quantite ;
    @NotBlank
    private Double cout_Location;
    @OneToMany(mappedBy = "equipement",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EquipementType> equipementTypes;

}
