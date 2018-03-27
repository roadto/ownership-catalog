package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.AERepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.BuildingRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.CloneRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.PrincipalityRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.RestoreUtil;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception.ExceptionUtils;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author Artem Krotov
 * Created on 30.11.2017.
 * @deprecated
 * TODO: В рамках задачи AM-18, AM-19, AM-20, AM-20
 */
@Deprecated
@Component
public class RestoreUtilImpl implements RestoreUtil {

    @Autowired
    private AERepository aeRepository;
    @Autowired
    private CloneRepository cloneRepository;
    @Autowired
    private PrincipalityRepository principalityRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void restorePrincipality(Clone clone) {
        Principality clonePrincipality = clone.getPrincipality();
        if (clonePrincipality != null) {
            Principality restoredPrincipality = findNotNull(clonePrincipality);
            clone.setPrincipality(restoredPrincipality);
            restoredPrincipality.setOwner(clone);
        }
    }

    @Override
    public void restoreAE(Clone clone) {
        AE cloneAe = clone.getAe();
        if (cloneAe != null) {
            AE restoredAe = findNotNull(cloneAe);
            clone.setAe(restoredAe);
            restoredAe.setOwner(clone);
        }
    }

    @Override
    public void restoreBuilding(Clone clone) {
        Set<Building> cloneBuildings = clone.getBuildings();
        if (!CollectionUtils.isEmpty(cloneBuildings)) {
            Set<Building> restoredBuildings = cloneBuildings.stream()
                    .map(building -> {
                        building = findNotNull(building);
                        building.setOwner(clone);
                        return building;
                    })
                    .collect(Collectors.toSet());
            clone.setBuildings(restoredBuildings);
        }
    }

    @Override
    public void restoreBuilding(AE ae) {
        Set<Building> aeBuildings = ae.getBuildings();
        if (!CollectionUtils.isEmpty(aeBuildings)) {
            Set<Building> restoredBuildings = aeBuildings.stream()
                    .map(building -> {
                        building = findNotNull(building);
                        building.setAe(ae);
                        return building;
                    })
                    .collect(Collectors.toSet());
            ae.setBuildings(restoredBuildings);
        }
    }

    @Override
    public void restorePrincipality(AE ae) {
        Principality aePrincipality = ae.getPrincipality();
        if (aePrincipality != null) {
            Principality restoredPrincipality = findNotNull(aePrincipality);
            if (restoredPrincipality != null) {
                ae.setPrincipality(restoredPrincipality);
                Set<AE> restoredPrincipalityAes = restoredPrincipality.getAes();
                restoredPrincipalityAes.add(ae);
            }
        }
    }

    @Override
    public void restoreOwner(AE ae) {
        Clone aeOwner = ae.getOwner();
        if (aeOwner != null) {
            Clone restoredClone = findNotNull(aeOwner);
            ae.setOwner(restoredClone);
            restoredClone.setAe(ae);
        }
    }

    @Override
    public void restoreOwner(Building building) {

    }

    @Override
    public void restoreAE(Building building) {
        AE buildingAe = building.getAe();
        if (buildingAe != null) {
            AE restoredAe = findNotNull(buildingAe);
            building.setAe(restoredAe);
            Set<Building> restoredAeBuildings = restoredAe.getBuildings();
            restoredAeBuildings.add(building);
        }
    }

    /*
    @Override
    public void restoreAE(Building building, Building oldBuilding) {
        if (oldBuilding.getAe() != null) {
            oldBuilding.getAe().getBuildings().remove(oldBuilding);
        }
        AE restoredAe = findNotNull(building.getAe());
        building.setAe(restoredAe);
        Set<Building> restoredAeBuildings = restoredAe.getBuildings();
        restoredAeBuildings.add(building);
    }

    @Override
    public void restoreOwner(Building building, Building oldBuilding) {
        if (oldBuilding.getOwner() != null) {
            oldBuilding.getOwner().getBuildings().remove(building);
        }
        Clone restoredClone = findNotNull(building.getOwner());
        building.setOwner(restoredClone);
        Set<Building> restoredCloneBuildings = restoredClone.getBuildings();
        restoredCloneBuildings.add(building);
    }
    */

    @Override
    public void restoreOwner(Principality principality) {
        Clone principalityOwner = principality.getOwner();
        if (principalityOwner != null) {
            Clone restoredClone = findNotNull(principalityOwner);
            principality.setOwner(restoredClone);
            restoredClone.setPrincipality(principality);
        }
    }

    @Override
    public void restoreAE(Principality principality) {
        Set<AE> principalityAes = principality.getAes();
        if (!CollectionUtils.isEmpty(principalityAes)) {
            Set<AE> restoredAEs = principalityAes.stream()
                    .map(ae -> {
                        ae = findNotNull(ae);
                        ae.setPrincipality(principality);
                        return ae;
                    })
                    .collect(Collectors.toSet());
            principality.setAes(restoredAEs);
        }
    }

    private AE findNotNull(AE ae) {
        AE aeFromDao = aeRepository.findOne(ae.getId());
        if (aeFromDao == null) {
            ExceptionUtils.throwNotFoundException(
                    String.format("Error. AE with id = %d not found!",
                            ae.getId())
            );
        }

        return aeFromDao;
    }

    private Principality findNotNull(Principality principality) {

        Principality principalityFromDao = principalityRepository.findOne(principality.getId());
        if (principalityFromDao == null) {
            ExceptionUtils.throwNotFoundException(
                    String.format("Error. PRINCIPALITY with id = %d not found!",
                            principality.getId())
            );
        }

        return principalityFromDao;
    }

    private Building findNotNull(Building building) {

        try {
            building = buildingRepository.getOne(building.getId());
        } catch (ObjectNotFoundException e) {
            ExceptionUtils.throwNotFoundException(
                    String.format("Error. BUILDING with id = %d not found!",
                            building.getId())
            );
        }

        return building;
    }

    private Clone findNotNull(Clone clone) {
        try {
            clone = cloneRepository.getOne(clone.getId());
        } catch (ObjectNotFoundException e) {
            ExceptionUtils.throwNotFoundException(
                    String.format("Error. CLONE with id = %d not found!",
                            clone.getId())
            );
        }

        return clone;
    }
}
