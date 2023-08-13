package io.nopecho.domainevents.infra.jdbc.config.converter;

import io.nopecho.utils.Serializer;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Map;

@ReadingConverter
public enum ObjectReadingConverters implements Converter<PGobject, Map<String, Object>> {
    INSTANCE;

    @Override
    public Map<String, Object> convert(PGobject source) {
        return Serializer.convertMap(source.getValue());
    }
}
