package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Principality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
public interface PrincipalityRepository extends JpaRepository<Principality, Long> {

    Integer deleteByIdIn(List<Long> ids);

    Page<Principality> findByIdIn(List<Long> ids, Pageable pageable);
}
