package com.example.demo.core.configurationBeans;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.MySqlDialect;

@Configuration
public class CustomConverters {
    @Bean
    public R2dbcCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new UUIDToByteArrayConverter());
        converters.add(new ByteArrayToUUIDConverter());
        return R2dbcCustomConversions.of(MySqlDialect.INSTANCE, converters);
    }

    @WritingConverter
    private class UUIDToByteArrayConverter implements Converter<UUID, byte[]> {
        @Override
        public byte[] convert(UUID source) {
            ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
            bb.putLong(source.getMostSignificantBits());
            bb.putLong(source.getLeastSignificantBits());
            return bb.array();
        }
    }
    
    @ReadingConverter
    public class ByteArrayToUUIDConverter implements Converter<byte[], UUID> {
        @Override
        public UUID convert(byte[] source) {
            ByteBuffer bb = ByteBuffer.wrap(source);
            return new UUID(bb.getLong(), bb.getLong());
        }
    }
    
}