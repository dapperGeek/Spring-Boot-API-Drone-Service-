package com.geek0.drones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Medication {
    @Id
    private String id;
    private String name;
    private String medWeight;
    private String code;
    private String image;
}
