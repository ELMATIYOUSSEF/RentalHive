package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.enums.StatusEquipmentItems;
import com.rentalhive.repository.EquipmentItemsRepository;
import com.rentalhive.service.EquipementService;
import com.rentalhive.service.EquipmentItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentItemsServiceImpl implements EquipmentItemsService {

    private final EquipmentItemsRepository equipmentItemsRepository;
    private final EquipementService equipementService ;


    public EquipmentItem findByMatricul(String matricul) throws Exception {
        Optional<EquipmentItem> byMatricul = equipmentItemsRepository.findByMatricul(matricul);
        if (byMatricul.isPresent())
            return byMatricul.get();
        throw new Exception("This Matricul doesn't Exist ");
    }
    @Override
    public EquipmentItem save(EquipmentItem equipmentItem) throws Exception {
        Optional<EquipmentItem> byMatricul = equipmentItemsRepository.findByMatricul(equipmentItem.getMatricul());
        if (byMatricul.isEmpty())
            return equipmentItemsRepository.save(equipmentItem);
        throw new Exception("Equipment Type is Already Exist !");
    }

    public List<EquipmentItem> getEquipementTypesInStock() {
        return equipmentItemsRepository.findByStatusEquipementType(StatusEquipmentItems.inStock);
    }

}
