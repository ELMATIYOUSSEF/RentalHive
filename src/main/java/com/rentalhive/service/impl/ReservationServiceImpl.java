package com.rentalhive.service.impl;

        import com.rentalhive.domain.EquipmentItem;
        import com.rentalhive.domain.EquipmentItemsReservation;
        import com.rentalhive.domain.Reservation;
        import com.rentalhive.repository.EquipmentItemsRepository;
        import com.rentalhive.repository.ReservationEquipmentRepository;
        import com.rentalhive.repository.ReservationRepository;
        import com.rentalhive.service.ReservationService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;
        import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private  final ReservationRepository reservationRepository;
    private final ReservationEquipmentRepository reservationEquipmentRepository;
    private final EquipmentItemsRepository equipmentItemsRepository;


    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    @Override
    public EquipmentItemsReservation reservationEquipment(EquipmentItemsReservation reservation){
        return reservationEquipmentRepository.save(reservation);
    }
    @Override
    public List<EquipmentItem> findAvailableEquipementTypes(LocalDateTime dateStart , LocalDateTime dateRouter) {
        return equipmentItemsRepository.findAvailableEquipementTypes(dateStart,dateRouter);
    }

}

