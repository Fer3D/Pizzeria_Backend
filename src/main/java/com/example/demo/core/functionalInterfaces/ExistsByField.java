package com.example.demo.core.functionalInterfaces;

import reactor.core.publisher.Mono;

public interface ExistsByField {
    Mono<Boolean> existsByField(String field);
}