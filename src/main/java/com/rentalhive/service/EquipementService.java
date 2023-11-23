package com.rentalhive.service;

import com.rentalhive.domain.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipementService {
    Equipment Save(Equipment equipment) throws Exception;
    List<Equipment> getAllEquipements();

    Equipment searchByName(String name) throws Exception;
    Optional<Equipment> findById(long id) throws Exception;
    Equipment upDate(Equipment equipment) throws Exception ;
    Equipment update(Equipment equipment) throws Exception;
    Equipment getEquipementById(Long id);
}
