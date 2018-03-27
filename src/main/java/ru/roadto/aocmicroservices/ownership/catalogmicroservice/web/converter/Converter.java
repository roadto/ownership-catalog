package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
public interface Converter<M, D> extends org.springframework.core.convert.converter.Converter <M, D>{

    D convert(M model);

    boolean validate(M model);


}
