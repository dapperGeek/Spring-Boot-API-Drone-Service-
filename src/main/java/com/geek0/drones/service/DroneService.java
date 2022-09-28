package com.geek0.drones.service;

import com.geek0.drones.enums.State;
import com.geek0.drones.model.BatteryLog;
import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.BatteryLogsRepository;
import com.geek0.drones.repository.DroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@AllArgsConstructor
@Service
public class DroneService {
    private final DroneRepository droneRepository;
    private final BatteryLogsRepository batteryLogsRepository;
    private final MongoTemplate mongoTemplate;

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public Drone fetchDrone(String droneId) {
        return droneRepository.findDroneById(droneId);
    }

    public Iterable<Drone> registerDrone(Drone drone) {
        return doSave(drone);
    }

    public Iterable<Drone> updateDrone(Drone drone) {
        return doSave(drone);
    }

    private boolean checkBatteryForLoading(Drone drone) {
        if (drone.getBatteryLevel() < 25 && !drone.getState().equals(State.IDLE)) {
            return false;
        }
        return true;
    }

    private Iterable<Drone> doSave(Drone drone) {
        try {
            if (checkBatteryForLoading(drone))
            {
                droneRepository.save(drone);
                return droneRepository.findAll();
            }
            throw new java.lang.Error("Battery level is low. Put drone in IDLE state");
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }

        return null;
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

    public Iterable<BatteryLog> batteryLogs() {
        //todo: Retrieve battery logs and sort by drone id
        return batteryLogsRepository.findByOrderByDroneId();
    }

    public void alterBatteries() {
        Iterable<Drone> drones = droneRepository.findAll();

        for (Drone drone : drones) {
            int newBatteryLevel = drone.getBatteryLevel() - 3;

            if (drone.getBatteryLevel() <= 25 && !drone.getState().equals(State.IDLE)) {
                drone.setState(State.IDLE);
            }

            if (drone.getBatteryLevel() > 25) {
                drone.setBatteryLevel(newBatteryLevel);

            }

            droneRepository.save(drone);
        }
    }
}
