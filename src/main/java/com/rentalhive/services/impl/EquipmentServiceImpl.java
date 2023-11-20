package com.rentalhive.services.impl;

import com.rentalhive.domains.Equipment;
import com.rentalhive.repositories.EquipmentRepository;
import com.rentalhive.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public List<Equipment> getAllEquipements() {
        return equipmentRepository.findAll();
    }
    @Override
    public Equipment getEquipementById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }
    @Override
    public Equipment createEquipement(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public Equipment update(Equipment equipment) {
        Optional<Equipment> optionalExistingEquipment = findById(equipment.getId());
        if (optionalExistingEquipment.isEmpty()) {
            return null;
        }
        Equipment updatedEquipment = optionalExistingEquipment.get();
        updatedEquipment.setName(equipment.getName());
        updatedEquipment.setQuantite(equipment.getQuantite());
        updatedEquipment.setCout_Location(equipment.getCout_Location());
        updatedEquipment.setEquipmentTypes(equipment.getEquipmentTypes());
        return equipmentRepository.save(updatedEquipment);
    }

    @Override
    public void deleteEquipement(Long id){
        equipmentRepository.deleteById(id);
    }

}
