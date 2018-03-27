package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author Artem Krotov
 *         Created on 16.02.2018.
 */
public interface PrincipalityService {

    List<Principality> add(List<Principality> aes);

    List<Principality> update(List<Principality> aes);

    Integer remove(List<Long> ids);

    Page<Principality> findAll(Pageable pageable);

    Principality findOne(Long id);

    Page<Principality> findByIds(List<Long> ids, Pageable pageable);

}
