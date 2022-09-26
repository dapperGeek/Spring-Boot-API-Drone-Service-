package com.geek0.drones;

import com.geek0.drones.enums.ModelWeight;
import com.geek0.drones.enums.State;
import com.geek0.drones.model.Drone;
import com.geek0.drones.repository.DroneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
	}
}
