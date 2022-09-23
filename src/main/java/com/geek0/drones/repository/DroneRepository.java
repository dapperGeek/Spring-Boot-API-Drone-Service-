package com.geek0.drones.repository;

import com.geek0.drones.model.Drone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DroneRepository extends MongoRepository<Drone, String> {

    Drone findDroneById(String droneId);
}
