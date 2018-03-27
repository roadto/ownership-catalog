package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Artem Krotov
 *         Created on 27.11.2017.
 */
public interface AEService {

    List<AE> add(List<AE> aes);

    List<AE> update(List<AE> aes);

    Integer remove(List<Long> ids);

    Page<AE> findAll(Pageable pageable);

    AE findOne(Long id);

    Page<AE> findByIds(List<Long> ids, Pageable pageable);

}
