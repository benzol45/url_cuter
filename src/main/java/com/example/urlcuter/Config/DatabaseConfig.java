package com.example.urlcuter.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    private Environment environment;

    @Autowired
    public DatabaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
        hikariConfig.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        hikariConfig.setUsername(environment.getProperty("spring.datasource.username"));
        hikariConfig.setPassword(environment.getProperty("spring.datasource.password"));
        hikariConfig.setMaximumPoolSize(10);

        return new HikariDataSource(hikariConfig);
    }
}
