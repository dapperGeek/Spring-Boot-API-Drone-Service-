package com.geek0.drones.service;

import com.geek0.drones.model.Medication;
import com.geek0.drones.repository.MedicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;

    public List<Medication> getMedications() {
        return medicationRepository.findAll();
    }

    public void saveMedication(Medication medication) {
        medicationRepository.insert(medication);
    }
}
