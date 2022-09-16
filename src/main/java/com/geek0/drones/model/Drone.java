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

    public Drone(String serialNumber, double weight, int batteryLevel, ModelWeight modelWeight, State state) {
        this.serialNumber = serialNumber;
        this.weight = weight;
        this.batteryLevel = batteryLevel;
        this.modelWeight = modelWeight;
        this.state = state;
    }

    @Indexed(unique = true)
    private String serialNumber;
    private double weight;
    private int batteryLevel;
    private ModelWeight modelWeight;
    private State state;
}
