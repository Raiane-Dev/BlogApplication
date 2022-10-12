package com.application.blog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.application.blog")
@PropertySource("classpath:application.properties")
public class Database
{

    @Autowired
    Environment env;

    @Bean
    DataSource connect()
    {
        DriverManagerDataSource configDataSource = new DriverManagerDataSource();
        configDataSource.setUrl(env.getProperty("url"));
        configDataSource.setUsername(env.getProperty("dbuser"));
        configDataSource.setPassword(env.getProperty("dbpassword"));
        configDataSource.setDriverClassName(env.getProperty("driver"));

        return configDataSource;
    }

}