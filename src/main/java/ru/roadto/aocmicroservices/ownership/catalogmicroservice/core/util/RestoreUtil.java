package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;


/**
 * @author Artem Krotov
 * Created on 30.11.2017.
 */
public interface RestoreUtil {


    void restorePrincipality(Clone clone);

    void restoreAE(Clone clone);

    void restoreBuilding(Clone clone);

    void restoreBuilding(AE ae);

    void restorePrincipality(AE ae);

    void restoreOwner(AE ae);

    void restoreOwner(Building building);

    void restoreAE(Building building);

    void restoreOwner(Principality principality);

    void restoreAE(Principality principality);
}
