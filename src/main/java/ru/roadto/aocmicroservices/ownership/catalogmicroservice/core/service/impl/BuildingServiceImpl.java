package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.BuildingService;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

/**
 * @author Artem Krotov
 * Created on 30.11.2017.
 */
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Set<Building> add(Set<Building> requestBuildings) {
        return null;
    }

    @Override
    public Set<Building> update(Set<Building> requestBuildings) {
        return null;
    }

    @Override
    public Integer remove(Set<Long> ids) {
        return null;
    }

    @Override
    public Page<Building> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Building findOne(Long id) {
        return null;
    }

    @Override
    public Page<Building> findByIds(Set<Long> ids, Pageable pageable) {
        return null;
    }

}
