package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
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
public class PrincipalityDto {
    private Long id;
    private String name;
    private Clone owner;
    private Set<AE> aes;
}
