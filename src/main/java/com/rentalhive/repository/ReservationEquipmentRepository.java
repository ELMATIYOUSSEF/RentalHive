package com.rentalhive.repository;

import com.rentalhive.DTO.DevisInfoDTO;
import com.rentalhive.domain.EquipmentItemsReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationEquipmentRepository extends JpaRepository<EquipmentItemsReservation, Long> {
    @Query("SELECT max(eir) FROM EquipmentItemsReservation eir " +
            "INNER JOIN EquipmentItem ei ON eir.equipmentItem.id = ei.id " +
            "INNER JOIN Equipment e ON ei.equipment.id = e.id " +
            "INNER JOIN Reservation r ON eir.reservation.id = r.id " +
            "INNER JOIN User u ON r.user.id = u.id WHERE eir.id = :idR")
    EquipmentItemsReservation getEquipmentsInfo(
            Long idR
    );


    /*
        @Query(value="SELECT * FROM equipment_items_reservation " +
            "INNER JOIN equipment_item ON equipment_items_reservation.equipment_item_id = equipment_item.id " +
            "INNER JOIN equipment ON equipment_item.equipment_id = equipment.id " +
            "INNER JOIN reservation ON equipment_items_reservation.reservation_id = reservation.id " +
            "INNER JOIN user ON reservation.user_id = user.id WHERE user.id = :id",nativeQuery = true)
    DevisInfoDTO getEquipmentsInfo(
            @Param("id") Long id
    );
    */
}
