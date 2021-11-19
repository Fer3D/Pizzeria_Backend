package com.example.demo.core;

public class ApplicationBase {
    
}
package com.example.demo.core.functionalInterfaces;

import reactor.core.publisher.Mono;

public interface ExistsByField {
    Mono<Boolean> exists(String field);
}
