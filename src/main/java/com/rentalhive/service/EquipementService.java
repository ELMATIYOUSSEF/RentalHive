package com.rentalhive.service;

import com.rentalhive.domain.Equipement;

import java.util.List;

public interface EquipementService {
    List<Equipement> getAllEquipements();

    Equipement getEquipementById(Long id);

    Equipement createEquipement(Equipement equipement);
}
