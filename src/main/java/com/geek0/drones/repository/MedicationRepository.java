package com.geek0.drones.repository;

import com.geek0.drones.model.Medication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicationRepository extends MongoRepository<Medication, String> {
}
