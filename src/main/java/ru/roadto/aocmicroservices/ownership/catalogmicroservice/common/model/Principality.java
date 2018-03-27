package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.util.RestoreUtil;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Таблица княжеств
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "PRINCIPALITY")
public class Principality {

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
     * Владелец
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="OWNER_ID")
    private Clone owner;

    /**
     * Административные единицы
     */
    @OneToMany(mappedBy = "principality", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<AE> aes = new HashSet<>();

}
