package io.nopecho.auth.infra.jdbc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AuthDataSource {

    @Bean
    @ConditionalOnMissingBean
    public DataSource authDataSource() {
        return authDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSourceProperties authDataSourceProperties() {
        return new DataSourceProperties();
    }
}
