package com.rentalhive.domain;

import com.rentalhive.domain.enums.StatusReservation;
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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reservation" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<EquipementTypeReservation> equipementTypeReservations;

    @ManyToOne
    private User user;
    @NotBlank
    private StatusReservation statusReservation ;

}
