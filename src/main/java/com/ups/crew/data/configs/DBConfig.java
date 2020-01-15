package com.ups.crew.data.configs;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfig {

    @Value ("${spring.datasource.drivername}")
    private String driverName;

    @Value ("${spring.datasource.url}")
    private String url;

    @Value ("${spring.datasource.username}")
    private String userName;

    @Value ("${spring.datasource.password}")
    private String password;

    @Bean
    DataSource dataSource() throws SQLException{

        OracleDataSource oracleDataSource = new OracleDataSource();
        oracleDataSource.setDriverType(driverName);
        oracleDataSource.setURL(url);
        oracleDataSource.setUser(userName);
        oracleDataSource.setPassword(password);

        return dataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
}
