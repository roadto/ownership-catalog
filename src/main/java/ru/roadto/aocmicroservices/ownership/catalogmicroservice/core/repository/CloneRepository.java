package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model.Clone;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Artem Krotov
 * Created on 27.11.2017.
 */
public interface CloneRepository extends JpaRepository<Clone, Long> {

}
