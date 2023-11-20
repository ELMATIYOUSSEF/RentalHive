package com.rentalhive.services;

import com.rentalhive.domains.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipements();

    Equipment getEquipementById(Long id);

    Equipment createEquipement(Equipment equipment);
}
