package com.pluralsight.security.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Database configurations for the spring batch application. For the purposes of
 * this course, I'm simply leveraging an H2 database; however, its recommended
 * that you using a real production database server for all non-development
 * implementations. Includes support for JPA auditing.
 *
 */
@Configuration
@EnableJpaRepositories(
	value = "com.pluralsight.security.repository",
	entityManagerFactoryRef = "entityManagerFactory")
@EnableTransactionManagement
public class DatabaseConfiguration {

	private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

	private final Environment env;

	public DatabaseConfiguration(Environment env) {
		this.env = env;
	}

	@Primary
    @Bean(name = "dataSource")
    public DataSource batchDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
        config.setUsername(env.getProperty("spring.datasource.username"));
        config.setPassword(env.getProperty("spring.datasource.password"));
        config.setMinimumIdle(env.getProperty("spring.datasource.min-idle",
            Integer.class, 2));
        config.setMaximumPoolSize(env.getProperty("spring.datasource.max-active",
            Integer.class, 100));
        config.setTransactionIsolation("TRANSACTION_READ_COMMITTED");
        config.setRegisterMbeans(true);
        return new HikariDataSource(config);
    }

    @Bean(name = "jpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfBean =
            new LocalContainerEntityManagerFactoryBean();
        emfBean.setDataSource(batchDataSource());
        emfBean.setPackagesToScan("com.pluralsight.security");
        emfBean.setBeanName("entityManagerFactory");
        emfBean.setJpaVendorAdapter(jpaVendorAdapter());

        Properties jpaProps = new Properties();
        jpaProps.put("hibernate.physical_naming_strategy",
            env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
        jpaProps.put("hibernate.hbm2ddl.auto", env.getProperty(
            "spring.jpa.hibernate.ddl-auto", "none"));
        jpaProps.put("hibernate.jdbc.fetch_size", env.getProperty(
            "spring.jpa.properties.hibernate.jdbc.fetch_size",
            "200"));

        jpaProps.put("hibernate.show_sql", env.getProperty(
            "spring.jpa.properties.hibernate.show_sql", "true"));
        jpaProps.put("hibernate.format_sql",env.getProperty(
            "spring.jpa.properties.hibernate.format_sql", "true"));

        emfBean.setJpaProperties(jpaProps);
        return emfBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public MBeanExporter exporter() {
        final MBeanExporter exporter = new MBeanExporter();
        exporter.setExcludedBeans("dataSource");
        return exporter;
    }

}
