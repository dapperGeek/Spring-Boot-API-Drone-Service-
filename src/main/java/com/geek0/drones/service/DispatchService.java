package com.geek0.drones.service;

import com.geek0.drones.model.Dispatch;
import com.geek0.drones.model.Medication;
import com.geek0.drones.repository.DispatchRepository;
import com.geek0.drones.repository.MedicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DispatchService {
    private final DispatchRepository dispatchRepository;
    private final MedicationRepository medicationRepository;
    private final MedicationService medicationService;

    public List<Dispatch> getDispatches() {
        return dispatchRepository.findAll();
    }

    public void saveUpdateDispatch(Dispatch dispatch) {
        List<String> medicationIds = dispatch.getMedicationIds();
        Iterable<Medication> medications = medicationService.medicationsByIds(medicationIds);
        int totalWeight = 0;
        //TODO: Make max weight globally accessible constant
        int maxWeight = 500;

        for (Medication medication : medications) {
            totalWeight += medication.getWeight();
        }

        //TODO: Include respective responses for successful and failed create dispatches depending on weight. Return JSONObject
        if (totalWeight <= maxWeight) {
            dispatchRepository.save(dispatch);
        }

    }

    /**
     * Fetch loaded medications for a given drone
     * @param droneId
     * @return
     */
    public Iterable<Medication> fetchLoadedMedications(String droneId) {
        //get dispatch details by droneId
        Dispatch dispatch = fetchDispatchByDroneId(droneId);
        List<String> medicationsIds = dispatch.getMedicationIds();

        return medicationService.medicationsByIds(medicationsIds);
    }

    /**
     * Fetch dispatch details for a chosen drone
     * @param droneId
     * @return
     */
    public Dispatch fetchDispatchByDroneId(String droneId) {
        return dispatchRepository.findByDroneId(droneId);
    }
}
