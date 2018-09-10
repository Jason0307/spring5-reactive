package org.zhubao.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.zhubao.model.Dog;

public interface DogRepository extends ReactiveMongoRepository<Dog, String> {

}
