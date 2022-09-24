package com.geek0.drones.service;

import com.geek0.drones.enums.State;
import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.DroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DroneService {
    private final DroneRepository droneRepository;
    private final MongoTemplate mongoTemplate;

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public void registerDrone(Drone drone) {
        droneRepository.insert(drone);
    }

    /**
     * Fetch drone battery level
     * @param droneId (id of selected/given drone)
     * @return Integer (Battery level)
     */
    public Integer fetchDroneBatteryLevel(String droneId) {
        Drone drone = droneRepository.findDroneById(droneId);
        return drone.getBatteryLevel();
    }

    public List<Drone> fetchLoadableDrones() {
//        List<Drone> loadableDrone = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("state").in(State.IDLE, State.LOADING));
        query.addCriteria(Criteria.where("batteryLevel").gt(25));

        return mongoTemplate.find(query, Drone.class);
    }
}
