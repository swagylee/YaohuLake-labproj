package com.example.demo.config.dao;

import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${entity_package}")
    private String entityPackage;
    @Value("${mapper_path}")
    private String mapperPath;
    @Autowired
    private DataSource dataSource;

    public SessionFactoryConfiguration() {
    }

    @Bean(
            name = {"sqlSessionFactory"}
    )
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(this.mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = "classpath*:" + this.mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(this.dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(this.entityPackage);
        return sqlSessionFactoryBean;
    }
}
