package com.rentalhive.service.impl;

import com.rentalhive.domain.Devis;
import com.rentalhive.service.DevisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DevisServiceImpl implements DevisService {
    @Override
    public Devis addDevis(Devis devis) {
        return null;
    }

    @Override
    public List<Devis> getListDevis() {
        return null;
    }

    @Override
    public Devis updateDevis(Devis devis) {
        return null;
    }

    @Override
    public void deleteDevis(Long id) {

    }

    @Override
    public Optional<Devis> findDevis(Long id) {
        return Optional.empty();
    }
}
