package io.nopecho.saga.orchestration.adapter.persistence;

import io.nopecho.saga.orchestration.adapter.persistence.converter.ObjectReadingConverters;
import io.nopecho.saga.orchestration.adapter.persistence.converter.ObjectWritingConverters;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.convert.Jsr310TimestampBasedConverters;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableJdbcAuditing
public class DataJdbcConfig extends AbstractJdbcConfiguration {

    public static Collection<Converter<?, ?>> getConvertersToRegister(Converter<?, ?>... converter) {
        List<Converter<?, ?>> converters = new ArrayList<>(5 + converter.length);
        converters.add(Jsr310TimestampBasedConverters.LocalDateTimeToTimestampConverter.INSTANCE);
        converters.add(Jsr310TimestampBasedConverters.TimestampToLocalDateTimeConverter.INSTANCE);
        converters.add(ObjectReadingConverters.INSTANCE);
        converters.add(ObjectWritingConverters.INSTANCE);
        Collections.addAll(converters, converter);
        return converters;
    }

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        List<Object> converters = new ArrayList<>(
                getConvertersToRegister()
        );
        return new JdbcCustomConversions(converters);
    }
}
