package com.geek0.drones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Document
public class Medication {
    @Id
    private String id;
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9-_]")
    private String name;
    @NotNull
    private double weight;
    @NotNull
    @Indexed(unique = true)
    @Pattern(regexp = "[A-Z0-9_]")
    private String code;
    private String image;

    public Medication(
            String name,
            double weight,
            String code,
            String image
    )
    {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }
}
