package com.geek0.drones.model;

import com.geek0.drones.enums.ModelWeight;
import com.geek0.drones.enums.State;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Drone {
    @Id
    private String id;
    @Indexed(unique = true)
    private String serialNumber;
    private double weightLimit;
    private int batteryLevel;
    private ModelWeight modelWeight;
    private State state;

    public Drone(String serialNumber, double weightLimit, int batteryLevel, ModelWeight modelWeight, State state) {
        this.serialNumber = serialNumber;
        this.weightLimit = weightLimit;
        this.batteryLevel = batteryLevel;
        this.modelWeight = modelWeight;
        this.state = state;
    }
}
