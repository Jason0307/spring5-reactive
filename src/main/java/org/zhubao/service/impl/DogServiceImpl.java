package org.zhubao.service.impl;

import org.springframework.stereotype.Service;
import org.zhubao.model.Dog;
import org.zhubao.repository.DogRepository;
import org.zhubao.service.DogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Mono<Dog> buyDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Flux<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Mono<Dog> findDog(String id) {
        return dogRepository.findById(id);
    }

}
