package com.example.demo.domain.imageDomain;

//import java.util.UUID;
import reactor.core.publisher.Mono;

public interface ImageRepository {
    public Mono<Image> add(Image image);
    /*public Mono<byte[]> get(UUID id);*/
}