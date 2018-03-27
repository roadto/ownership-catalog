package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.AE;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Repository
public interface AERepository extends JpaRepository<AE, Long> {
}
