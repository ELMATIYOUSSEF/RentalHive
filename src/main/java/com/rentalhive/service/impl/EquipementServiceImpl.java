package com.rentalhive.service.impl;

import com.rentalhive.domain.Equipement;
import com.rentalhive.repository.EquipmentRepository;
import com.rentalhive.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public  EquipementServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipement Save(Equipement equipement) throws Exception {
        Equipement byname = equipmentRepository.findByName(equipement.getName());
        if (byname== null)
            return equipmentRepository.save(equipement);
        throw new Exception("This Equipment is Already Exist ");
    }
    @Override
    public Equipement searchByName(String name) throws Exception {
        Equipement Eq_name = equipmentRepository.findByName(name);
        if (!Eq_name.getName().isEmpty())
            return Eq_name;
        throw new Exception("Not found This Equipment ");
    }
    @Override
    public Equipement upDate(Equipement equipement) throws Exception{
        if(equipement!= null) {
            equipement.setQuantite(equipement.getQuantite() + 1);
            return equipmentRepository.save(equipement);
        }
        throw  new Exception("Equipment doesn't Exist ") ;
    }

    @Override
    public Equipement findById(long id) throws Exception{
        Optional<Equipement> byId = equipmentRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        throw  new Exception("this Equipment doesn't Exist !");
    }
    @Override
    public Equipement update(Equipement equipment) throws Exception {
        Equipement updatedEquipment = findById(equipment.getId());
        updatedEquipment.setName(equipment.getName());
        updatedEquipment.setQuantite(equipment.getQuantite());
        updatedEquipment.setCout_Location(equipment.getCout_Location());
        updatedEquipment.setEquipmentItems(equipment.getEquipmentItems());
        return equipmentRepository.save(updatedEquipment);
    }
}
