package org.zhubao.route;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zhubao.handler.DogHandler;

@Configuration
public class DogRoute {

    @Bean
    public RouterFunction<ServerResponse> dogRoutes(DogHandler dogHandler) {
        return nest(path("/dogs/v2"),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(method(HttpMethod.GET), dogHandler::getAllDogs)
                                .andRoute(GET("/{id}"), dogHandler::findDog).andRoute(method(HttpMethod.POST),
                                        dogHandler::buyDog)));
    }
}
