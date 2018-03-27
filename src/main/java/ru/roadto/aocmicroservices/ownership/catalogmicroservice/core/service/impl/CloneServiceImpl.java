package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.CloneRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.CloneService;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author Artem Krotov
 * Created on 30.11.2017.
 */
public class CloneServiceImpl implements CloneService {

    private final CloneRepository cloneRepository;

    @Autowired
    public CloneServiceImpl(CloneRepository cloneRepository) {
        this.cloneRepository = cloneRepository;
    }

    @Override
    public List<Clone> add(List<Clone> aes) {
        return null;
    }

    @Override
    public List<Clone> update(List<Clone> aes) {
        return null;
    }

    @Override
    public Integer remove(List<Long> ids) {
        return null;
    }

    @Override
    public Page<Clone> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Clone findById(Long id) {
        return null;
    }

    @Override
    public Page<Clone> findByIds(List<Long> ids, Pageable pageable) {
        return null;
    }
}
