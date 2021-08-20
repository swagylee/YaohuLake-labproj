package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.example.demo.dao"})
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    public DataSourceConfiguration() {
    }

    @Bean(
            name = {"dataSource"}
    )
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.jdbcDriver);
        dataSource.setJdbcUrl(this.jdbcUrl);
        dataSource.setUser(this.jdbcUsername);
        dataSource.setPassword(this.jdbcPassword);
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}

