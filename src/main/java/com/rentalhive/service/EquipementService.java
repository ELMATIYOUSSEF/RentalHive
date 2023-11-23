package com.rentalhive.service;

import com.rentalhive.domain.Equipement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EquipementService {
    Equipement Save(Equipement equipement) throws Exception;

    Equipement searchByName(String name) throws Exception;
    Equipement findById(long id) throws Exception;
    Equipement upDate(Equipement equipement) throws Exception ;
    Equipement update(Equipement equipment) throws Exception;
}
