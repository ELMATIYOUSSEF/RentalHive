package com.rentalhive.service.impl;

import com.rentalhive.DTO.DevisInfoDTO;
import com.rentalhive.domain.Devis;
import com.rentalhive.repository.DevisRepository;
import com.rentalhive.repository.ReservationEquipmentRepository;
import com.rentalhive.service.DevisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DevisServiceImpl implements DevisService {

    private final DevisRepository devisRepository;

    private final ReservationEquipmentRepository reservationEquipmentRepository;

    public DevisInfoDTO getEquipmentInfo(Long id){
        DevisInfoDTO dto = DevisInfoDTO.fromEquipmentItemsReservationToDTO(reservationEquipmentRepository.getEquipmentsInfo(id));
        return dto;
    }
    @Override
    public Devis addDevis(Devis devis) {
        return devisRepository.save(devis);
    }

    @Override
    public List<Devis> getListDevis() {
        return null;
    }

    @Override
    public Devis updateDevis(Devis devis) {
        return null;
    }

    @Override
    public void deleteDevis(Long id) {

    }

    @Override
    public Optional<Devis> findDevis(Long id) {
        return Optional.empty();
    }
}
