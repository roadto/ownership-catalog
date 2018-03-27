package ru.roadto.aocmicroservices.ownership.catalogmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants;


/**
 * @author Artem Krotov
 * Created on 16.11.2017.
 */
@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
public class OwnershipServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnershipServiceApplication.class, args);
	}

}
