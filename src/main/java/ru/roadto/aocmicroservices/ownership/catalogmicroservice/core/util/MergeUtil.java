package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;


/**
 * @author Artem Krotov
 * Created on 16.02.2018.
 */
public interface MergeUtil {

    void mergePrincipality(Clone clone, Clone oldClone);

    void mergeAE(Clone clone, Clone oldClone);

    void mergeBuilding(Clone clone, Clone oldClone);

    void mergeBuilding(AE ae, AE oldAE);

    void mergePrincipality(AE ae, AE oldAe);

    void mergeOwner(AE ae, AE oldAE);

    void mergeAE(Building building, Building oldBuilding);

    void mergeOwner(Building building, Building oldBuilding);

    void mergeOwner(Principality principality, Principality oldPrincipality);

    void mergeAE(Principality principality, Principality oldPrinciplaity);
}
