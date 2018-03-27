package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter.custom;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.PageableModel;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PageableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
@Component
public class PageableDtoConverter {

    @Autowired
    private ConversionService conversionService;

    public <D, E> List<?> convertToEntities(List<D> dtos, E targetClass) {
        return dtos.stream()
                .map(dto -> targetClass.getClass().cast(conversionService.convert(dto, targetClass.getClass())))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public <E, D> PageableDto<D> convertToPageableDto(Page<E> page, D targetClass) {

        final int offset = page.getNumber() * page.getSize();

        PageableModel<E> pageableModel = new PageableModel<E>(
                page.getContent(),
                new ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.Page(offset, page.getSize()),
                (int) page.getTotalElements()
        );

        return new PageableDto<>(
                pageableModel.getLimit(),
                pageableModel.getOffset(),
                pageableModel.getSort(),
                pageableModel.getTotalCount(),
                convertToDtos(pageableModel.getData(), targetClass));
    }

    public   <E, D> List<?> convertToDtos(List<E> models, D targetClass) {
        return models.stream()
                .map(model -> (targetClass.getClass().cast(conversionService.convert(model, targetClass.getClass()))))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
