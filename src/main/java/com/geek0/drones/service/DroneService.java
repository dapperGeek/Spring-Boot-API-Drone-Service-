package com.geek0.drones.service;

import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.DroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DroneService {
    private final DroneRepository droneRepository;

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
}
