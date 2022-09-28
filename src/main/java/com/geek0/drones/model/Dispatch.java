package com.geek0.drones.model;

import com.geek0.drones.enums.State;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Dispatch {
    @Id
    private String id;
    private String droneId;
    private List<String> medicationIds;
    private State state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    public Dispatch(String droneId, List<String> medicationIds) {
//        this.droneId = droneId;
//        this.medicationIds = medicationIds;
//    }

//    public Dispatch(String droneId, List<String> medicationIds, State state, LocalDateTime createdAt) {
//        this.droneId = droneId;
//        this.medicationIds = medicationIds;
//        this.state = state;
//        this.createdAt = createdAt;
//    }

    public Dispatch(String droneId, List<String> medicationIds, State state, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.droneId = droneId;
        this.medicationIds = medicationIds;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
