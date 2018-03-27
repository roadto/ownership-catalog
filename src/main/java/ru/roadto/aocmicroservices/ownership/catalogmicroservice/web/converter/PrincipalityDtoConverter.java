package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PrincipalityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
@Slf4j
@Component
public class PrincipalityDtoConverter implements Converter<Principality, PrincipalityDto> {

    @Override
    public PrincipalityDto convert(Principality model) {

        if (validate(model)) {
            return PrincipalityDto.builder()
                    .id(model.getId())
                    .name(model.getName())
                    .aes(model.getAes())
                    .owner(model.getOwner())
                    .build();
        }

        return null;

    }

    @Override
    public boolean validate(Principality model) {
        return true;
    }
}
