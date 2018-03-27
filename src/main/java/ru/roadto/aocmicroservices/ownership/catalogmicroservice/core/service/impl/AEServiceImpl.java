package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.AERepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.AEService;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
@Service
public class AEServiceImpl implements AEService {

    private final AERepository aeRepository;

    @Autowired
    public AEServiceImpl(AERepository aeRepository) {
        this.aeRepository = aeRepository;
    }

    @Override
    public List<AE> add(List<AE> requestAes) {
        return null;
    }

    @Override
    public List<AE> update(List<AE> requestAes) {
        return null;
    }

    @Override
    public Integer remove(List<Long> ids) {
        return null;
    }

    @Override
    public Page<AE> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public AE findOne(Long id) {
        return null;
    }

    @Override
    public Page<AE> findByIds(List<Long> ids, Pageable pageable) {
        return null;
    }



}
