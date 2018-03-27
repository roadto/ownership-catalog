package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Core.Db.*;


/**
 * @author Artem Krotov
 * Created on 20.11.2017.
 */
@Configuration
@Profile(value = {"junit"})
public class EmbeddedDBConfiguration {

    @Primary
    @Bean(name = DATA_SOURCE)
    public DataSource searchServiceDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("embedded")
                .build();
    }

    @Bean(name = JPA_VENDOR_ADAPTER)
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");

        return adapter;
    }

    @Bean(name = JPA_PROPERTIES)
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.fetch_size", 50);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("org.hibernate.flushMode", "COMMIT");
        properties.put("hibernate.show_sql", false);
        return properties;
    }

}
