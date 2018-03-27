package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model;

import java.io.Serializable;

/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public interface Identifiable<T extends Number> extends Serializable {
    T getId();
}