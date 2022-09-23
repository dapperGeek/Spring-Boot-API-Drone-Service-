package com.geek0.drones.controller;

import com.geek0.drones.model.Drone;
import com.geek0.drones.model.Medication;
import com.geek0.drones.service.DispatchService;
import com.geek0.drones.service.DroneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/drones")
@AllArgsConstructor
public class DroneController {
    private final DroneService droneService;
    private final DispatchService dispatchService;

    @GetMapping
    public List<Drone> fetchDrones() {
        return droneService.getAllDrones();
    }

    @PostMapping
    public void registerDrone(@RequestBody Drone drone) {
        droneService.registerDrone(drone);
    }

    @GetMapping("/{droneId}/medications")
    public Iterable<Medication> fetchLoadedMedications(@PathVariable("droneId") String droneId) {

        return dispatchService.fetchLoadedMedications(droneId);
    }

//    public Iterable<Drone> fetchLoadingDrones() {
//
//    }
}
