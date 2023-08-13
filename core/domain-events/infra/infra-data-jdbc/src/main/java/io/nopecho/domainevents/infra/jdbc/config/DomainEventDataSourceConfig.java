package io.nopecho.domainevents.infra.jdbc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DomainEventDataSourceConfig {

    @Bean
    @ConditionalOnMissingBean
    public DataSource domainEventDataSource() {
        return domainEventDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSourceProperties domainEventDataSourceProperties() {
        return new DataSourceProperties();
    }
}
