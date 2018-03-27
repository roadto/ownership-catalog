package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.PageRequest;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.CloneDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PageableDto;

import java.util.List;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.Parameters;
import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.RestApi;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public interface CloneApi {

    @RequestMapping(path = RestApi.CLONES, method = RequestMethod.POST)
    List<Long> post(@RequestBody List<CloneDto> facets);

    @RequestMapping(path = RestApi.CLONES, params = "ids", method = RequestMethod.DELETE)
    Integer deleteByIds(@RequestParam("ids") List<Long> ids);

    @RequestMapping(path = RestApi.CLONES, method = RequestMethod.PUT)
    List<Long> update(@RequestBody List<CloneDto> facets);

    @RequestMapping(path = RestApi.CLONES, method = RequestMethod.GET)
    PageableDto<CloneDto> getAll(PageRequest pageRequest);

    @RequestMapping(path = RestApi.CLONES_BY_ID, method = RequestMethod.GET)
    CloneDto getById(@PathVariable(Parameters.DTOs.ID) Long id);

    @RequestMapping(path = RestApi.CLONES, params = "ids", method = RequestMethod.GET)
    PageableDto<CloneDto> getByIds(@RequestParam("ids") List<Long> ids, PageRequest semPageRequest);
}
