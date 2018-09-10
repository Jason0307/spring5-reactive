package org.zhubao.service;

import org.zhubao.model.Dog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DogService {

    /**
     * Buy a dog
     * @param dog
     * @return
     */
    Mono<Dog> buyDog(Dog dog);

    /**
     * List all the dogs
     * @return
     */
    Flux<Dog> getAllDogs();

    /**
     * Find a dog
     * @param id
     * @return
     */
    Mono<Dog> findDog(String id);
}
