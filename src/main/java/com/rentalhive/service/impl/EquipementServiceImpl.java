package com.rentalhive.service.impl;

import com.rentalhive.domain.Equipement;
import com.rentalhive.repository.EquipementRepository;
import com.rentalhive.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EquipementServiceImpl implements EquipementService {
    
    private final EquipementRepository equipementRepository;
    @Autowired
    public EquipementServiceImpl(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }
    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }
    @Override
    public Equipement getEquipementById(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }
    @Override
    public Equipement createEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

}
