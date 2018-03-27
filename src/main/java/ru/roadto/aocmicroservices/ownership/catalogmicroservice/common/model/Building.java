package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.enums.BuildingType;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.RestoreUtil;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


/**
 * Таблица княжеств
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "BUILDING")
public class Building {

    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private RestoreUtil restoreUtil;

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /**
     * Название
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Тип
     */
    @Column(name = "TYPE", updatable = false, insertable = false)
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    /**
     * Владелец
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID")
    private Clone owner;


    /**
     * Административная единица
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AE_ID")
    private AE ae;

    /**
     * Максимальный срок аренды
     */
    @Column(name = "TENANCY")
    private Long tenancy;

    /**
     * Количество арендаторов
     */
    @Column(name = "NUMBER_OF_TENANTS")
    private Long numberOfTenants;

    /**
     * Свободных комнат
     */
    @Column(name = "AVAILABLE_ROOMS")
    private Long availableRooms;


}
