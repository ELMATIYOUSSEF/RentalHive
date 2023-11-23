package com.rentalhive.service;

import com.rentalhive.domain.EquipmentItem;

import java.util.List;

public interface EquipmentItemsService {
    EquipmentItem save(EquipmentItem equipmentItem) throws Exception;
    EquipmentItem findByMatricul(String matricul) throws Exception;
    List<EquipmentItem> getEquipementTypesInStock();

}
