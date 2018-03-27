package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.enums.AeType;

import javax.persistence.*;
import java.util.Random;
import java.util.Set;

/**
 * Таблица административных единиц
 *
 * @author Artem Krotov
 *         Created on 22.11.2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "AE")
public class AE {

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
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private AeType aeType;

    /**
     * Владелец
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNER_ID")
    private Clone owner;

    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRINCIPALITY_ID")
    private Principality principality;

    /**
     * Постройки
     */
    @OneToMany(mappedBy = "ae", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Building> buildings;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        while (true) {
            long millis = random.nextInt(5) * 1000;
            if (millis != 0) {
                System.out.printf("Подожди %d секунд\n", millis / 1000);
                Thread.sleep(millis);
            } else {
                System.out.println("Нет времени ждать, действуй!");
                break;
            }
        }
    }

}
