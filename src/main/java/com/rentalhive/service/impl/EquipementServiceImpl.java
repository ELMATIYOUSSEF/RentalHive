package com.rentalhive.service.impl;

import com.rentalhive.domain.Equipment;
import com.rentalhive.repository.EquipmentRepository;
import com.rentalhive.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public  EquipementServiceImpl(EquipmentRepository equipmentRepository) {
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
    public Equipment Save(Equipment equipment) throws Exception {
        Equipment byname = equipmentRepository.findByName(equipment.getName());
        if (byname== null)
            return equipmentRepository.save(equipment);
        throw new Exception("This Equipment is Already Exist ");
    }
    @Override
    public Equipment searchByName(String name) throws Exception {
        Equipment Eq_name = equipmentRepository.findByName(name);
        if (!Eq_name.getName().isEmpty())
            return Eq_name;
        throw new Exception("Not found This Equipment ");
    }
    @Override
    public Equipment upDate(Equipment equipment) throws Exception{
        if(equipment != null) {
            equipment.setQuantite(equipment.getQuantite() + 1);
            return equipmentRepository.save(equipment);
        }
        throw  new Exception("Equipment doesn't Exist ") ;
    }

    @Override
    public Optional<Equipment> findById(long id) throws Exception{
        Optional<Equipment> byId = equipmentRepository.findById(id);
        if (byId.isPresent()){
            return byId;
        }
        throw  new Exception("this Equipment doesn't Exist !");
    }
    @Override
    public Equipment update(Equipment equipment) throws Exception {
        Optional<Equipment> optionalExistingEquipment = findById(equipment.getId());
        if (optionalExistingEquipment.isEmpty()) {
            return null;
        }
        Equipment updatedEquipment = optionalExistingEquipment.get();
        updatedEquipment.setName(equipment.getName());
        updatedEquipment.setQuantite(equipment.getQuantite());
        updatedEquipment.setCout_Location(equipment.getCout_Location());
        updatedEquipment.setEquipmentItems(equipment.getEquipmentItems());
        return equipmentRepository.save(updatedEquipment);
    }


}
