package com.example.demo.core.functionalInterfaces;

import reactor.core.publisher.Mono;

public interface ExistByField {
    Mono<Boolean> exists(String field);
}
