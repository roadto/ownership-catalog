package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.impl;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository.PrincipalityRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.service.PrincipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Artem Krotov
 * Created on 30.11.2017.
 */
@Service
public class PrincipalityServiceImpl implements PrincipalityService {

    private final PrincipalityRepository principalityRepository;

    @Autowired
    public PrincipalityServiceImpl(PrincipalityRepository principalityRepository) {
        this.principalityRepository = principalityRepository;
    }

    @Override
    public List<Principality> add(List<Principality> aes) {
        return null;
    }

    @Override
    public List<Principality> update(List<Principality> aes) {
        return null;
    }

    @Override
    public Integer remove(List<Long> ids) {
        return null;
    }

    @Override
    public Page<Principality> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Principality findOne(Long id) {
        return null;
    }

    @Override
    public Page<Principality> findByIds(List<Long> ids, Pageable pageable) {
        return null;
    }
}
