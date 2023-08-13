package io.nopecho.members.infra.jdbc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MemberDataSource {

    @Bean
    @ConditionalOnMissingBean
    public DataSource memberDataSource() {
        return memberDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSourceProperties memberDataSourceProperties() {
        return new DataSourceProperties();
    }
}
