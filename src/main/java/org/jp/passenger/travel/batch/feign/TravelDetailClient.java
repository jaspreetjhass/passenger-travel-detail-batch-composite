package org.jp.passenger.travel.batch.feign;

import org.jp.passenger.travel.batch.dto.TravelDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TravelDetailClient", url = "http://localhost:8070/passengerCore")
public interface TravelDetailClient {

	@GetMapping("/{passengerId}")
	TravelDetailDTO fetchTravelDetail(@PathVariable("passengerId") Long passengerId);

}
