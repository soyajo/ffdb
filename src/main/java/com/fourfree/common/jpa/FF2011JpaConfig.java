package com.fourfree.common.jpa;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * 1. 프로젝트명 : api
 * 2. 패키지명   : com.fourfree.common.jpa
 * 3. 작성일     : 2020. 06. 18. 오후 3:42
 * 4. 작성자     : 고병만
 * 5. 이메일     : scormrte@gmail.com
 * 6  연락처     : 010-8299-5258
 */


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.fourfree.ff2011",
        transactionManagerRef = FF2011JpaConfig.TransactionManager,
        entityManagerFactoryRef = FF2011JpaConfig.EntityManager
)

public class FF2011JpaConfig {
    @Value("${spring.profiles.active}")
    public String active;

    @Value("${ff2011.url}")
    public String url;

    @Value("${ff2011.user}")
    public String user;

    @Value("${ff2011.password}")
    public String password;

    @Value("${ff2011.poolname}")
    public String poolname;

    @Value("${ff2011.poolsize}")
    public Integer poolsize;

    public final static String EntityManager = "ff2011_entityManagerFactory";
    public final static String TransactionManager = "ff2011_transactionManager";

    @Bean(name = EntityManager)
    public LocalContainerEntityManagerFactoryBean ff2011_entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ff2011_DataSource());
        em.setPackagesToScan("com.fourfree.ff2011");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(JpaProperties.oracle_additionalProperties(active));
        return em;
    }

    @Bean
    public DataSource ff2011_DataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        Properties properties = new Properties();
        hikariConfig.setDataSourceClassName(oracle.jdbc.pool.OracleDataSource.class.getName());
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        hikariConfig.setPoolName(poolname);
        hikariConfig.setMaximumPoolSize(poolsize);
        hikariConfig.setLeakDetectionThreshold(0);
        hikariConfig.setIdleTimeout(600000);
        hikariConfig.setMaxLifetime(295000);
        hikariConfig.setConnectionTimeout(300000);
        hikariConfig.setConnectionTestQuery("select 1 from dual");
        hikariConfig.setDataSourceProperties(properties);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        if (active.equals("dev")) {
            Log4JdbcCustomFormatter log4JdbcCustomFormatter = new Log4JdbcCustomFormatter();
            log4JdbcCustomFormatter.setLoggingType(LoggingType.MULTI_LINE);
            log4JdbcCustomFormatter.setSqlPrefix("SQL:::");
            Log4jdbcProxyDataSource log4jdbcProxyDataSource = new Log4jdbcProxyDataSource(dataSource);
            log4jdbcProxyDataSource.setLogFormatter(log4JdbcCustomFormatter);
            return log4jdbcProxyDataSource;
        } else {
            return new LazyConnectionDataSourceProxy(dataSource);
        }

    }

    @Bean(name = TransactionManager)
    public PlatformTransactionManager ff2011_transactionManager(@Qualifier(EntityManager) EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
