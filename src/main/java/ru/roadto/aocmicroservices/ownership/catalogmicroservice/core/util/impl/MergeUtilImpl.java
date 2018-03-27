package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.RestoreUtil;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.MergeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;


/**
 * @author Artem Krotov
 * Created on 16.02.2018.
 * @deprecated
 * TODO: В рамках задачи AM-18, AM-19, AM-20, AM-20
 */
@Deprecated
@Component
public class MergeUtilImpl implements MergeUtil {

    @Autowired
    private RestoreUtil restoreUtil;

    @Override
    public void mergePrincipality(Clone clone, Clone oldClone) {
        Principality clonePrincipality = clone.getPrincipality();
        if (clonePrincipality != null) {
            restoreUtil.restorePrincipality(clone);
            oldClone.setPrincipality(clonePrincipality);
        }
    }

    @Override
    public void mergeAE(Clone clone, Clone oldClone) {
        AE cloneAe = clone.getAe();
        if (cloneAe != null) {
            restoreUtil.restoreAE(clone);
            oldClone.setAe(cloneAe);
        }
    }

    @Override
    public void mergeBuilding(Clone clone, Clone oldClone) {
        Set<Building> cloneBuildings = clone.getBuildings();
        if (!CollectionUtils.isEmpty(cloneBuildings)) {
            restoreUtil.restoreBuilding(clone);
            oldClone.setBuildings(cloneBuildings);
        }
    }

    @Override
    public void mergeBuilding(AE ae, AE oldAE) {
        Set<Building> aeBuildings = ae.getBuildings();
        if (!CollectionUtils.isEmpty(aeBuildings)) {
            restoreUtil.restoreBuilding(ae);
            oldAE.setBuildings(aeBuildings);
        }
    }

    @Override
    public void mergePrincipality(AE ae, AE oldAe) {
        Principality aePrincipality = ae.getPrincipality();
        if (aePrincipality != null) {
            restoreUtil.restorePrincipality(ae);
            oldAe.setPrincipality(aePrincipality);
        }
    }

    @Override
    public void mergeOwner(AE ae, AE oldAE) {
        Clone aeOwner = ae.getOwner();
        if (aeOwner != null) {
            restoreUtil.restoreOwner(ae);
            oldAE.setOwner(aeOwner);
        }
    }

    @Override
    public void mergeAE(Building building, Building oldBuilding) {
        AE buildingAe = building.getAe();
        if (buildingAe != null) {
            restoreUtil.restoreAE(building);
            oldBuilding.setAe(buildingAe);
        }
    }

    @Override
    public void mergeOwner(Building building, Building oldBuilding) {
        Clone buildingOwner = building.getOwner();
        if (buildingOwner != null) {
            restoreUtil.restoreOwner(building);
            oldBuilding.setOwner(buildingOwner);
        }
    }

    @Override
    public void mergeOwner(Principality principality, Principality oldPrincipality) {
        Clone principalityOwner = principality.getOwner();
        if (principalityOwner != null) {
            restoreUtil.restoreOwner(principality);
            oldPrincipality.setOwner(principalityOwner);
        }
    }

    @Override
    public void mergeAE(Principality principality, Principality oldPrinciplaity) {
        Set<AE> principalityAes = principality.getAes();
        if (!CollectionUtils.isEmpty(principalityAes)) {
            restoreUtil.restoreAE(principality);
            oldPrinciplaity.setAes(principalityAes);
        }
    }
}
