package org.jp.passenger.travel.batch.tasklet;

import org.jp.passenger.travel.batch.dto.TravelDetailDTO;
import org.jp.passenger.travel.batch.feign.TravelDetailClient;
import org.jp.passenger.travel.batch.service.PassengerService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoadDBData implements Tasklet {

	@Autowired
	private PassengerService passengerService;
	@Autowired
	private TravelDetailClient travelDetailClient;

	@Override
	public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
		passengerService.fetchAllPassenger().parallelStream().forEach(passenger -> {
			final TravelDetailDTO travelDetailDTO = travelDetailClient.fetchTravelDetail(passenger.getId());
			log.info("Passenger travel details is {}", travelDetailDTO);
		});
		return RepeatStatus.FINISHED;
	}

}
