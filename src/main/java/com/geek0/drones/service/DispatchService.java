package com.geek0.drones.service;

import com.geek0.drones.Constants;
import com.geek0.drones.model.Dispatch;
import com.geek0.drones.model.Medication;
import com.geek0.drones.repository.DispatchRepository;
import com.geek0.drones.repository.MedicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
//        int maxWeight = Constants.getMaxWeight();
        List<String> medicationIds = dispatch.getMedicationIds();
        Iterable<Medication> medications = medicationService.medicationsByIds(medicationIds);
        int totalWeight = 0;
        int maxWeight = 200;

        for (Medication medication : medications) {
            totalWeight += medication.getWeight();
        }

        if (totalWeight > maxWeight) {

        }

        dispatchRepository.save(dispatch);
    }

    public List fetchLoadedMeds(List<String> medicationIds) {
        return (List) medicationRepository.findAllById(medicationIds);
    }
}
