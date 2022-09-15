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
}
