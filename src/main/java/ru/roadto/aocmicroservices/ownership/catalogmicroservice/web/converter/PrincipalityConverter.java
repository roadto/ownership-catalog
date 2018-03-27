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
public class PrincipalityConverter implements Converter<PrincipalityDto, Principality> {

    @Override
    public Principality convert(PrincipalityDto dto) {

        if (validate(dto)) {
            return Principality.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .aes(dto.getAes())
                    .owner(dto.getOwner())
                    .build();
        }

        return null;

    }

    @Override
    public boolean validate(PrincipalityDto dto) {
        return true;
    }
}
