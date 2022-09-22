package com.geek0.drones.repository;

import com.geek0.drones.model.Dispatch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DispatchRepository extends MongoRepository<Dispatch, String> {
}
