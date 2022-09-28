package com.geek0.drones.model;

import com.geek0.drones.enums.ModelWeight;
import com.geek0.drones.enums.State;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document
public class Drone {
    @Id
    private String id;
    @Indexed(unique = true)
    @NotNull
    @Size(min = 10, max = 100)
    private String serialNumber;
    @Max(500)
    private double weightLimit;
    private int batteryLevel;
    private ModelWeight modelWeight;
    private State state;

    public Drone(
            String serialNumber,
            double weightLimit,
            int batteryLevel,
            ModelWeight modelWeight,
            State state
    )
    {
        this.serialNumber = serialNumber;
        this.weightLimit = weightLimit;
        this.batteryLevel = batteryLevel;
        this.modelWeight = modelWeight;
        this.state = state;
    }
}
