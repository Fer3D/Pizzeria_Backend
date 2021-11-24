package com.example.demo.infraestructure.imageInfraestructure;

import java.time.Duration;
//import java.util.UUID;

import com.example.demo.domain.imageDomain.Image;
import com.example.demo.domain.imageDomain.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ImageRepositoryImp implements ImageRepository {
    private final ReactiveRedisOperations<String, byte[]> redisOperations;

    @Autowired
    public ImageRepositoryImp(final ReactiveRedisOperations<String, byte[]> redisOperations) {
        this.redisOperations = redisOperations;
    }

    @Override
    public Mono<Image> add(Image image) {
        return redisOperations.opsForValue().set(image.getId().toString(), image.getImage(), Duration.ofDays(1))
                .map(img -> image);

    }

    /*@Override
    public Mono<byte[]> get(UUID id) {
        return redisOperations.opsForValue().get(id).map(result -> new Id(result, id));
    }*/

}

