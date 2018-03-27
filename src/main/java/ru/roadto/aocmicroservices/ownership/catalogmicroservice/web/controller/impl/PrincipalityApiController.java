package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.controller.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.controller.PrincipalityApi;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PrincipalityDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.PageRequest;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter.custom.PageableDtoConverter;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.PrincipalityRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PageableDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Core.Sort.NAME;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
@Slf4j
@RestController
public class PrincipalityApiController implements PrincipalityApi {

    @Autowired
    private PrincipalityRepository principalityRepository;
    @Autowired
    private PageableDtoConverter pageableDtoConverter;
    @Autowired
    private ConversionService conversionService;

    @Override
    public List<Long> post(@RequestBody List<PrincipalityDto> principalityDtos) {
        List<Principality> principalities = (List<Principality>) pageableDtoConverter.convertToEntities(principalityDtos, Principality.builder().build());
        List<Principality> savePrincipalities = principalityRepository.save(principalities);
        return savePrincipalities.stream().map(Principality::getId).collect(Collectors.toList());
    }

    @Override
    public Integer deleteByIds(@RequestParam("ids") List<Long> ids) {
        return principalityRepository.deleteByIdIn(ids);
    }

    @Override
    public List<Long> update(@RequestBody List<PrincipalityDto> aeDtos) {
        return post(aeDtos);
    }

    @Override
    public PageableDto<PrincipalityDto> getAll(PageRequest pageRequest) {
        Page page = Page.getPageWithDefaultSort(pageRequest, new Sort(Sort.Direction.DESC, NAME));
        org.springframework.data.domain.Page<Principality> pageFromDao = principalityRepository.findAll(page);
        return pageableDtoConverter.convertToPageableDto(
                pageFromDao,
                PrincipalityDto.builder().build()
        );
    }

    @Override
    public PrincipalityDto getById(@PathVariable(Constants.Web.Parameters.DTOs.ID) Long id) {
        Principality ae = principalityRepository.findOne(id);
        return conversionService.convert(ae, PrincipalityDto.class);
    }

    @Override
    public PageableDto<PrincipalityDto> getByIds(@RequestParam("ids") List<Long> ids, PageRequest pageRequest) {
        Page page = Page.getPageWithDefaultSort(pageRequest, new Sort(Sort.Direction.DESC, NAME));
        org.springframework.data.domain.Page<Principality> pageFromDao = principalityRepository.findByIdIn(ids, page);
        return pageableDtoConverter.convertToPageableDto(
                pageFromDao,
                PrincipalityDto.builder().build()
        );
    }
}
