package io.nopecho.commons.infra.jdbc;

import io.nopecho.commons.infra.jdbc.converters.ObjectReadingConverters;
import io.nopecho.commons.infra.jdbc.converters.ObjectWritingConverters;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.convert.Jsr310TimestampBasedConverters;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories(basePackages = "io.nopecho")
public class DataJdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    @Primary
    public NamedParameterJdbcOperations namedParameterJdbcOperations() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return dataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    @Primary
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        List<Object> converters = new ArrayList<>(
                getConvertersToRegister()
        );
        return new JdbcCustomConversions(converters);
    }

    public static Collection<Converter<?, ?>> getConvertersToRegister(Converter<?, ?>... converter) {
        List<Converter<?, ?>> converters = new ArrayList<>(5 + converter.length);
        converters.add(Jsr310TimestampBasedConverters.LocalDateTimeToTimestampConverter.INSTANCE);
        converters.add(Jsr310TimestampBasedConverters.TimestampToLocalDateTimeConverter.INSTANCE);
        converters.add(ObjectReadingConverters.INSTANCE);
        converters.add(ObjectWritingConverters.INSTANCE);
        Collections.addAll(converters, converter);
        return converters;
    }
}
