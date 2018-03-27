package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.configs;


import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter.AEConverter;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter.PrincipalityConverter;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter.PrincipalityDtoConverter;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.converter.AEDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author Artem Krotov
 * Created on 20.11.2017.
 */
@Configuration
@ComponentScan(value = {"com.akcompany.ownershipservice.web.controllers.*"})
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ConversionService conversionService () {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new AEConverter());
        service.addConverter(new AEDtoConverter());
        service.addConverter(new PrincipalityConverter());
        service.addConverter(new PrincipalityDtoConverter());
        return service;
    }



}
