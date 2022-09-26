package com.geek0.drones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class BatteryLog {
    @Id
    private String id;
    private String droneId;
    private int batteryLevel;
    private LocalDateTime dateTime;

    public BatteryLog(String droneId, int batteryLevel, LocalDateTime dateTime) {
        this.droneId = droneId;
        this.batteryLevel = batteryLevel;
        this.dateTime = dateTime;
    }
}
