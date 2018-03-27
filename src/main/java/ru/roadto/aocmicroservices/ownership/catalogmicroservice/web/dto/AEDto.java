package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.enums.AeType;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Building;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AEDto {

    private Long id;
    private String name;
    private AeType aeType;
    private Clone owner;
    private Principality principality;
    private Set<Building> buildings;

}
