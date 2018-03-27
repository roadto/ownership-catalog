package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;


/**
 * @author Artem Krotov
 * Created on 20.11.2017.
 */
@Configuration
@Import({
        EmbeddedDBConfiguration.class,
        MySqlConfiguration.class,
})
@EntityScan(basePackages = {"ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository",
        "ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model"})
@EnableJpaRepositories(
        basePackages = {"ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.repository",
                "ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model"},
        entityManagerFactoryRef = Constants.Core.Db.ENTITY_MANAGER_FACTORY,
        transactionManagerRef = Constants.Core.Db.TRANSACTION_MANAGER
)
public class DBConfiguration {

    @Autowired
    protected DataSource dataSource;

    @Autowired
    @Qualifier(Constants.Core.Db.JPA_VENDOR_ADAPTER)
    private JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    @Qualifier(Constants.Core.Db.JPA_PROPERTIES)
    private Properties jpaProperties;

    @Primary
    @Bean(name = Constants.Core.Db.ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        System.out.println("init666");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(Constants.Core.Db.PACKAGES_TO_SCAN);
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Bean(name = Constants.Core.Db.TRANSACTION_MANAGER)
    public JpaTransactionManager jpaTransactionManager(@Qualifier(Constants.Core.Db.ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = Constants.Core.Db.JDBC_TEMPLATE)
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = Constants.Core.Db.NAMED_JDBC_TEMPLATE)
    public NamedParameterJdbcTemplate namedJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
