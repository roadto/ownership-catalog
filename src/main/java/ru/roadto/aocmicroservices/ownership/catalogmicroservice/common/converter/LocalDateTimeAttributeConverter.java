package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
// TODO: А нужно ли?
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return (timestamp == null ? null : timestamp.toLocalDateTime());
    }

}
