package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.AEDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Slf4j
@Component
public class AEDtoConverter implements Converter<AE, AEDto> {

    @Override
    public AEDto convert(AE model) {

        if (validate(model)) {
            return AEDto.builder()
                    .id(model.getId())
                    .name(model.getName())
                    .aeType(model.getAeType())
                    .principality(model.getPrincipality())
                    .owner(model.getOwner())
                    .buildings(model.getBuildings())
                    .build();
        }

        return null;

    }

    @Override
    public boolean validate(AE model) {
        return true;
    }
}
