package com.geek0.drones.service;

import com.geek0.drones.model.BatteryLog;
import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.BatteryLogsRepository;
import com.geek0.drones.repository.DroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class BatteryLogsService {
    private final BatteryLogsRepository batteryLogsRepository;
    private final DroneRepository droneRepository;

    public void logBatteryLevels() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Iterable<Drone> drones = droneRepository.findAll();

        for (Drone drone : drones) {
            batteryLogsRepository.insert(
              new BatteryLog(
                      drone.getId(),
                      drone.getBatteryLevel(),
                      localDateTime
              )
            );
        }

    }
}
