package com.geek0.drones.controller;

import com.geek0.drones.model.Medication;
import com.geek0.drones.service.MedicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medications")
@AllArgsConstructor
public class MedicationController {
    private final MedicationService medicationService;

    @GetMapping
    public List<Medication> fetchMedications() {
        return medicationService.getMedications();
    }

    @PostMapping
    public void saveMedication(@RequestBody Medication medication) {
        medicationService.saveMedication(medication);
    }
}
