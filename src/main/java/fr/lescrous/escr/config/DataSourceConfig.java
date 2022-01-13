package fr.lescrous.escr.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("fr.lescrous.escr.dao")
@EnableTransactionManagement
@DependsOn("propertySourcesPlaceholderConfigurer")
public class DataSourceConfig {

    @Value("${escr.datasource.db_type}")
    private String dbType;

    @Value("${escr.datasource.db_url}")
    private String url;

    @Value("${escr.datasource.db_username}")
    private String username;

    @Value("${escr.datasource.db_password}")
    private String password;

    private final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public DataSource getDataSource() {
        LOG.error("OYOYOYOYOYOYOYOYOOYOYOYOYOYOYYOYOYO");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        switch (dbType) {
            case "sqlserver" :
                dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                break;
            case "maria" :
                dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
                break;
            case "mysql" :
                dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
                break;
            default:
                break;
        }

        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("fr.lescrous.escr.entities");
        factory.setDataSource(getDataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
