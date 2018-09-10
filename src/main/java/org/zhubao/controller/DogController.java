package org.zhubao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhubao.model.Dog;
import org.zhubao.service.DogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dogs/v1")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public Flux<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @PostMapping
    public Mono<Dog> buyDog(@RequestBody Dog dog) {
        return dogService.buyDog(dog);
    }

    @GetMapping("/{id}")
    public Mono<Dog> findDog(@PathVariable(name = "id") String id) {
        return dogService.findDog(id);
    }
}
