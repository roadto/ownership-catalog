package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.AEDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Slf4j
@Component
public class AEConverter implements Converter<AEDto, AE> {

    @Override
    public AE convert(AEDto dto) {

        if (validate(dto)) {
            return AE.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .aeType(dto.getAeType())
                    .principality(dto.getPrincipality())
                    .owner(dto.getOwner())
                    .buildings(dto.getBuildings())
                    .build();
        }

        return null;

    }

    @Override
    public boolean validate(AEDto dto) {
        return true;
    }
}
