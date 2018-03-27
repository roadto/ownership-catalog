package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @author Artem Krotov
 * Created on 20.11.2017.
 */
@Configuration
@Profile({"mysql"})
public class MySqlConfiguration {

    @Primary
    @Bean(name = Constants.Core.Db.DATABASE_PROPERTIES_BEAN)
    @ConfigurationProperties(Constants.Core.Db.DATABASE_PROPERTIES)
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @RefreshScope
    @Bean(name = Constants.Core.Db.DATA_SOURCE)
    @ConfigurationProperties(prefix = Constants.Core.Db.DATABASE_PROPERTIES)
    public DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = Constants.Core.Db.JPA_VENDOR_ADAPTER)
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }

    @Bean(name = Constants.Core.Db.JPA_PROPERTIES)
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.fetch_size", 50);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("org.hibernate.flushMode", "COMMIT");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hbm2ddl.auto", "create");

        return properties;
    }

}
