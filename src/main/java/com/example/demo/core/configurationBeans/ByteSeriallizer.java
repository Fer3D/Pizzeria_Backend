package com.example.demo.core.configurationBeans;

import org.springframework.data.redis.serializer.RedisSerializer;

import io.micronaut.core.serialize.exceptions.SerializationException;

import lombok.NoArgsConstructor;

public @NoArgsConstructor class ByteSeriallizer implements RedisSerializer<byte[]>{
    @Override
    public byte[] serialize(byte[] t) throws SerializationException {
        return t;
    }
 
    @Override
    public byte[] deserialize(byte[] bytes) throws SerializationException {
        return bytes;
    }
}