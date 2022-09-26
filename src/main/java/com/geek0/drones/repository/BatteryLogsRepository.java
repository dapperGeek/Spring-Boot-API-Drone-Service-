package com.geek0.drones.repository;

import com.geek0.drones.model.BatteryLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatteryLogsRepository extends MongoRepository<BatteryLog, String > {
}
