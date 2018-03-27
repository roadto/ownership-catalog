package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
