package org.zhubao.handler;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zhubao.model.Dog;
import org.zhubao.service.DogService;

import reactor.core.publisher.Mono;

@Component
public class DogHandler {

    private final DogService dogService;

    public DogHandler(DogService dogService) {
        this.dogService = dogService;
    }

    public Mono<ServerResponse> findDog(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(dogService.findDog(request.pathVariable("id")), Dog.class);
    }
    
    public Mono<ServerResponse> getAllDogs(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(dogService.getAllDogs(), Dog.class);
    }
    
    public Mono<ServerResponse> buyDog(ServerRequest serverRequest) {
        final Mono<Dog> dog = serverRequest.bodyToMono(Dog.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(dog.flatMap(dogService::buyDog), Dog.class));
    }
}
