package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.controller;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.PageRequest;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.AEDto;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto.PageableDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.*;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public interface AEApi {

    @RequestMapping(path = RestApi.AES, method = RequestMethod.POST)
    List<Long> post(@RequestBody List<AEDto> facets);

    @RequestMapping(path = RestApi.AES, params = "ids", method = RequestMethod.DELETE)
    Integer deleteByIds(@RequestParam("ids") List<Long> ids);

    @RequestMapping(path = RestApi.AES, method = RequestMethod.PUT)
    List<Long> update(@RequestBody List<AEDto> facets);

    @RequestMapping(path = RestApi.AES, method = RequestMethod.GET)
    PageableDto<AEDto> getAll(PageRequest pageRequest);

    @RequestMapping(path = RestApi.AES_BY_ID, method = RequestMethod.GET)
    AEDto getById(@PathVariable(Constants.Web.Parameters.DTOs.ID) Long id);

    @RequestMapping(path = RestApi.AES, params = "ids", method = RequestMethod.GET)
    PageableDto<AEDto> getByIds(@RequestParam("ids") List<Long> ids, PageRequest semPageRequest);
}
