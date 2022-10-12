package com.application.blog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.application.blog")
@PropertySource("classpath:application.properties")
public class Database
{

    @Autowired
    Environment env;

    private final String URL = "";
    private final String USER = "";
    private final String DRIVER = "";
    private final String PASSWORD = "";

    @Bean
    DataSource connect()
    {
        DriverManagerDataSource configDataSource = new DriverManagerDataSource();
        configDataSource.setUrl( env.getProperty(URL) );
        configDataSource.setUsername(USER);
        configDataSource.setPassword(PASSWORD);
        configDataSource.setDriverClassName(DRIVER);

        return configDataSource;
    }

}