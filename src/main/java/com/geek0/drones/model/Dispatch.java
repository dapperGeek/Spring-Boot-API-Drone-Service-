package com.geek0.drones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document
public class Dispatch {
    @Id
    private String id;
//    @DocumentReference
    private String droneId;
//    @DocumentReference
    private List<String> medicationIds;

    public Dispatch(String droneId, List<String> medicationIds) {
        this.droneId = droneId;
        this.medicationIds = medicationIds;
    }
}
