package com.rentalhive.repository;

import com.rentalhive.domain.EquipmentItemsReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationEquipmentRepository extends JpaRepository<EquipmentItemsReservation, Long> {
}
