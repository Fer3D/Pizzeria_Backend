package com.example.demo.core.functionalInterfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ExistByField {
    public Mono<Boolean> existsByField(String field);
}
