package com.rentalhive.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rentalhive.domain.enums.StatusReservation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reservation" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<EquipmentItemsReservation> equipmentItemsReservations;

    @ManyToOne
    private User user;
    @NotBlank
    private StatusReservation statusReservation ;

}
