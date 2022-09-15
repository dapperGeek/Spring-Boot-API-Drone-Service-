package com.geek0.drones.controller;

import com.geek0.drones.model.Drone;
import com.geek0.drones.service.DroneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/drones")
@AllArgsConstructor
public class DroneController {
    private final DroneService droneService;

    @GetMapping
    public List<Drone> fetchDrones() {
        return droneService.getAllDrones();
    }
}
