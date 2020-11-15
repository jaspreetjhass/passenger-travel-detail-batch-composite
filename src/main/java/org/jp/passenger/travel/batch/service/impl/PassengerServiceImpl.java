package org.jp.passenger.travel.batch.service.impl;

import java.util.List;

import org.jp.passenger.travel.batch.entity.Passenger;
import org.jp.passenger.travel.batch.repository.PassengerRepository;
import org.jp.passenger.travel.batch.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public List<Passenger> fetchAllPassenger() {
		return passengerRepository.findAll();
	}

}
