package com.example.demo.infraestructure.imageInfraestructure;

import java.util.UUID;

import com.example.demo.domain.imageDomain.Image;

import reactor.core.publisher.Mono;

public interface ImageRepository {
    public Mono<Image> add(Image image);
    public Mono<Image> getImageRedis(UUID id);
}