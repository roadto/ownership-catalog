package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.RestoreUtil;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "CLONE")
public class Clone {

    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private RestoreUtil restoreServicere;
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
     * Княжество
     */
    @OneToOne(mappedBy = "owner")
    private Principality principality;

    /**
     * Административная единица
     */
    @OneToOne(mappedBy = "owner")
    private AE ae;

    /**
     * Постройки
     */
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Building> buildings = new HashSet<>();



}
