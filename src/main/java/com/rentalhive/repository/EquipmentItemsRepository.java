package com.rentalhive.repository;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.enums.StatusEquipmentItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentItemsRepository extends JpaRepository<EquipmentItem, Long> {
    @Query("select et from EquipmentItem et where et.Matricul = :matricul")
    Optional<EquipmentItem> findByMatricul(String matricul);

    List<EquipmentItem> findByStatusEquipementType(StatusEquipmentItems statusEquipementType);
    @Query(value = "SELECT et.* FROM equipement_type et " +
            "INNER JOIN equipement_type_reservation etr ON et.id = etr.equipement_type_id " +
            "WHERE et.status_equipement_type = :statusEquipementType " +
            "AND etr.date_reservation >= :dateStart " +
            "AND etr.date_retoure <= :dateReturn",
            nativeQuery = true)
    List<EquipmentItem> findByStatusEquipementTypeAndDateRange(
            @Param("statusEquipementType") StatusEquipmentItems statusEquipementType,
            @Param("dateStart") LocalDateTime dateStart,
            @Param("dateReturn") LocalDateTime dateReturn);



    @Query("SELECT et FROM EquipmentItem et " +
            "WHERE et.id NOT IN " +
            "(SELECT rsi.equipmentItem.id FROM EquipmentItemsReservation rsi " +
            "WHERE (rsi.dateReservation < :endDate AND rsi.dateRetoure > :startDate) " +
            "   OR (:startDate BETWEEN rsi.dateReservation AND rsi.dateRetoure) " +
            "   OR (:endDate BETWEEN rsi.dateReservation AND rsi.dateRetoure))")
    List<EquipmentItem> findAvailableEquipementTypes(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

}
