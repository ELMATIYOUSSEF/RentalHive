package com.rentalhive.services;

import com.rentalhive.domains.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    List<Equipment> getAllEquipements();

    Equipment getEquipementById(Long id);

    Equipment createEquipement(Equipment equipment);

    Optional<Equipment> findById(Long id);
    Equipment update(Equipment equipment);
}
