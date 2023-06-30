package io.nopecho.springevents.adapters.out.persistence.converter;

import io.nopecho.utils.Serializer;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.sql.SQLException;
import java.util.Map;

@WritingConverter
public enum ObjectWritingConverters implements Converter<Map<String, Object>, PGobject> {
    INSTANCE;

    @Override
    public PGobject convert(Map<String, Object> source) {
        String serialize = Serializer.serialize(source);
        PGobject jsonObject = new PGobject();
        jsonObject.setType("json");
        try {
            jsonObject.setValue(serialize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return jsonObject;
    }
}
