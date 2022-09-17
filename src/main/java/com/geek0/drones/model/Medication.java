package com.geek0.drones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Medication {
    @Id
    private String id;
    private String name;
    private String weight;
    @Indexed(unique = true)
    private String code;
    private String image;

    public Medication(String name, String weight, String code, String image) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }
}
