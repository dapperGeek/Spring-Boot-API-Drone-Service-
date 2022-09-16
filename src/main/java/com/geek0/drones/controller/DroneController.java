package com.geek0.drones.controller;

import com.geek0.drones.enums.ModelWeight;
import com.geek0.drones.enums.State;
import com.geek0.drones.model.Drone;
import com.geek0.drones.service.DroneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerDrone(@RequestBody Drone drone) {
//        Drone sample = new Drone(
//                "SEP-12673-FIG",
//                50.0,
//                58,
//                ModelWeight.LIGHTWEIGHT,
//                State.IDLE
//        )
        droneService.registerDrone(drone);
    }
}
