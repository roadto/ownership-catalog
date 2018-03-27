package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author Artem Krotov
 * Created on 30.11.2017.
 */
public interface CloneService {

    List<Clone> add(List<Clone> aes);

    List<Clone> update(List<Clone> aes);

    Integer remove(List<Long> ids);

    Page<Clone> findAll(Pageable pageable);

    Clone findById(Long id);

    Page<Clone> findByIds(List<Long> ids, Pageable pageable);
}
