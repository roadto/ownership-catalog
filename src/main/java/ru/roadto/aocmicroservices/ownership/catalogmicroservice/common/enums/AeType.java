package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author Artem Krotov
 * Created on 17.11.2017.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AeType {

    /**
     * Хутор
     */
    LEVEL_1,

    /**
     * Деревня
     */
    LEVEL_2,

    /**
     * Село
     */
    LEVEL_3,

    /**
     * Город
     */
    LEVEL_4;
}
