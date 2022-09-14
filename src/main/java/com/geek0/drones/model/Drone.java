package com.geek0.drones.model;

import com.geek0.drones.enums.ModelWeight;
import com.geek0.drones.enums.State;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Drone {
    private String id;
    private String serialNumber;
    private double weight;
    private int batteryLevel;
    private ModelWeight modelWeight;
    private State state;
}
