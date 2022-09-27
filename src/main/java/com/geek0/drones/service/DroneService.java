package com.geek0.drones.service;

import com.geek0.drones.enums.State;
import com.geek0.drones.model.BatteryLog;
import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.DroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DroneService {
    private final DroneRepository droneRepository;
    private final MongoTemplate mongoTemplate;

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public Drone fetchDrone(String droneId) {
        return droneRepository.findDroneById(droneId);
    }

    public Iterable<Drone> registerDrone(Drone drone) {
        droneRepository.save(drone);
        return droneRepository.findAll();
    }

    public Iterable<Drone> updateDrone(Drone drone) {
        droneRepository.save(drone);
        return droneRepository.findAll();
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

    public Iterable<Drone> fetchLoadableDrones() {
        Query query = new Query();
        query.addCriteria(Criteria.where("state").in(State.IDLE, State.LOADING));
        query.addCriteria(Criteria.where("batteryLevel").gt(25));

        return mongoTemplate.find(query, Drone.class);
    }

    public void alterBatteries() {
        Iterable<Drone> drones = droneRepository.findAll();

        for (Drone drone : drones) {
            int newBatteryLevel = drone.getBatteryLevel() - 3;

            if (drone.getBatteryLevel() <= 25) {
                drone.setState(State.IDLE);
            }

            drone.setBatteryLevel(newBatteryLevel);

            droneRepository.save(drone);
            }

//        return droneRepository.findAll();
    }
}
