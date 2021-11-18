package com.example.demo.infraestructure;

import reactor.core.publisher.Mono;

public interface Add <I, O> {
    public Mono<O> add(I entity);
}
