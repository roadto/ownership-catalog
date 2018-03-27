package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.controller;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.PageRequest;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PrincipalityDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PageableDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.Parameters;
import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.RestApi;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
public interface PrincipalityApi {

    @RequestMapping(path = RestApi.PRINCIPALITIES, method = RequestMethod.POST)
    List<Long> post(@RequestBody List<PrincipalityDto> facets);

    @RequestMapping(path = RestApi.PRINCIPALITIES, params = "ids", method = RequestMethod.DELETE)
    Integer deleteByIds(@RequestParam("ids") List<Long> ids);

    @RequestMapping(path = RestApi.PRINCIPALITIES, method = RequestMethod.PUT)
    List<Long> update(@RequestBody List<PrincipalityDto> facets);

    @RequestMapping(path = RestApi.PRINCIPALITIES, method = RequestMethod.GET)
    PageableDto<PrincipalityDto> getAll(PageRequest pageRequest);

    @RequestMapping(path = RestApi.PRINCIPALITIES_BY_ID, method = RequestMethod.GET)
    PrincipalityDto getById(@PathVariable(Parameters.DTOs.ID) Long id);

    @RequestMapping(path = RestApi.PRINCIPALITIES, params = "ids", method = RequestMethod.GET)
    PageableDto<PrincipalityDto> getByIds(@RequestParam("ids") List<Long> ids, PageRequest semPageRequest);
}
