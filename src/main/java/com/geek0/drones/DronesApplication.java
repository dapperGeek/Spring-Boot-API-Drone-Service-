package com.geek0.drones;

import com.geek0.drones.enums.ModelWeight;
import com.geek0.drones.enums.State;
import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.DroneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(DroneRepository droneRepository) {
//
//		return args -> {
//			Drone drone = new Drone(
//					"SN00288399IJB",
//					98.0,
//					68,
//					ModelWeight.MIDDLEWEIGHT,
//					State.IDLE
//			);
//
//			droneRepository.insert(drone);
//		};
//	}
}
