package com.geek0.drones;

import com.geek0.drones.model.Drone;
import com.geek0.drones.service.BatteryLogsService;
import com.geek0.drones.service.DroneService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScheduledTasks {
    private final BatteryLogsService batteryLogsService;
    private final DroneService droneService;

    @Scheduled(fixedRate = 60000)
    public void batteryLogger() {
        batteryLogsService.logBatteryLevels();
    }

    @Scheduled(fixedDelay = 30000)
    public void alterBatteryLevel() {
        droneService.alterBatteries();
    }
}
