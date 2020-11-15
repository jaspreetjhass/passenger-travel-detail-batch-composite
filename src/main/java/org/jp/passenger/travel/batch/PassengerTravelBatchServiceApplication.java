package org.jp.passenger.travel.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableBatchProcessing
@EnableFeignClients
@SpringBootApplication
public class PassengerTravelBatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerTravelBatchServiceApplication.class, args);
	}

}
