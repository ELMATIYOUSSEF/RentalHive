package com.rentalhive.service;

import com.rentalhive.domain.Devis;

import java.util.List;
import java.util.Optional;

public interface DevisService {
    Devis addDevis(Devis devis);
    List<Devis> getListDevis();
    Devis updateDevis(Devis devis);
    void deleteDevis(Long id);
    Optional<Devis> findDevis(Long id);
}
