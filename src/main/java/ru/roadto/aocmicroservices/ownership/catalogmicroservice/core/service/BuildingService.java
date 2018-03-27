package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

/**
 * @author Artem Krotov,
 * Created on 30.11.2017.
 */
public interface BuildingService {

    Set<Building> add(Set<Building> aes);

    Set<Building> update(Set<Building> aes);

    Integer remove(Set<Long> ids);

    Page<Building> findAll(Pageable pageable);

    Building findOne(Long id);

    Page<Building> findByIds(Set<Long> ids, Pageable pageable);
}
