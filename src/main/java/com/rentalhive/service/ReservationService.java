package com.rentalhive.service;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.domain.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    EquipmentItemsReservation reservationEquipment(EquipmentItemsReservation reservation);
    List<EquipmentItem> findAvailableEquipementTypes(LocalDateTime dateStart , LocalDateTime dateRouter);
}
