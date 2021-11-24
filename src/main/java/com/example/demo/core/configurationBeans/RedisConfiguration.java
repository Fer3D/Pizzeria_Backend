package com.example.demo.core.configurationBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {
	@Bean
	ReactiveRedisOperations<String, byte[]> redisOperations(ReactiveRedisConnectionFactory factory) {
        ByteSeriallizer setValueSerializer = new ByteSeriallizer();

		RedisSerializationContext.RedisSerializationContextBuilder<String, byte[]> builder =
		RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

		RedisSerializationContext<String, byte[]> context = builder.value(setValueSerializer).build();

		return new ReactiveRedisTemplate<>(factory, context);
	}

}