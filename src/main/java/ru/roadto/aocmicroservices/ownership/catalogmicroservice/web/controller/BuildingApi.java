package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.BuildingDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.PageRequest;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PageableDto;

import java.util.List;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.Parameters;
import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.RestApi;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public interface BuildingApi {

    @RequestMapping(path = RestApi.BUILDINGS, method = RequestMethod.POST)
    List<Long> post(@RequestBody List<BuildingDto> facets);

    @RequestMapping(path = RestApi.BUILDINGS, params = "ids", method = RequestMethod.DELETE)
    Integer deleteByIds(@RequestParam("ids") List<Long> ids);

    @RequestMapping(path = RestApi.BUILDINGS, method = RequestMethod.PUT)
    List<Long> update(@RequestBody List<BuildingDto> facets);

    @RequestMapping(path = RestApi.BUILDINGS, method = RequestMethod.GET)
    PageableDto<BuildingDto> getAll(PageRequest pageRequest);

    @RequestMapping(path = RestApi.BUILDINGS_BY_ID, method = RequestMethod.GET)
    BuildingDto getById(@PathVariable(Parameters.DTOs.ID) Long id);

    @RequestMapping(path = RestApi.BUILDINGS, params = "ids", method = RequestMethod.GET)
    PageableDto<BuildingDto> getByIds(@RequestParam("ids") List<Long> ids, PageRequest semPageRequest);
}
