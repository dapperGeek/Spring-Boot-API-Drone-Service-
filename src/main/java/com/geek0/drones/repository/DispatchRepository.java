package com.geek0.drones.repository;

import com.geek0.drones.model.Dispatch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DispatchRepository extends MongoRepository<Dispatch, String> {

    Dispatch findByDroneId(String droneId);
}
