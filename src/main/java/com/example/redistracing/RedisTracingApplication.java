package com.example.redistracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.listener.ReactiveRedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class RedisTracingApplication {

	@Bean(destroyMethod = "destroy")
	public ReactiveRedisMessageListenerContainer reactiveRedisMessageListenerContainer(
			ReactiveRedisConnectionFactory connectionFactory
	) {
		return new ReactiveRedisMessageListenerContainer(connectionFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisTracingApplication.class, args);
	}

}
