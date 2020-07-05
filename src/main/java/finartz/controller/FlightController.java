package finartz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finartz.common.CommonResponse;
import finartz.constants.ResponseCodes;
import finartz.dao.FlightRepository;
import finartz.dao.RouteRepository;
import finartz.entity.FlightEntity;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired RouteRepository routeRepository;
	
	@PostMapping(path = "/createFlight")
	public CommonResponse createFlight (@RequestBody FlightEntity flightEntity) {
		CommonResponse response = new CommonResponse();
		response = checkFields(flightEntity, response);
		if (response.getResponseCode() != 0) return response;
		flightEntity.setRemainSeatCount(flightEntity.getSeatCount());
		flightRepository.save(flightEntity);
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		response.setResponseMessage(ResponseCodes.SUCCESFUL_RESPONSE_MESSAGE);
		return response;
	}

	private CommonResponse checkFields(FlightEntity flightEntity, CommonResponse response) {
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		if(flightEntity.getflightAirlineID() == 0 || flightEntity.getFlightDate().equals("") || flightEntity.getPrice() == 0.00 || flightEntity.getSeatCount() == 0 || flightEntity.getRouteId().contentEquals("")) {
			response.setResponseCode(ResponseCodes.FIELD_EMPTY_CODE);
			response.setResponseMessage(ResponseCodes.FIELD_EMPTY_MESSAGE);
			return response;
		}
		if (!routeRepository.findById(Integer.valueOf(flightEntity.getRouteId())).isPresent()) {
			response.setResponseCode(ResponseCodes.ROUTE_NOT_FOUND_CODE);
			response.setResponseMessage(ResponseCodes.ROUTE_NOT_FOUND_MESSAGE);
			return response;
		}
		return response;
	}
	
	@PostMapping(path = "/listAllFlights")
	public List < FlightEntity > listAllFlights () {
		return flightRepository.findAll();
	}
	
	@PostMapping(path = "/searchFlight")
	public FlightEntity searchFlights (@RequestBody FlightEntity flightEntity) {
		Optional <FlightEntity> flight = flightRepository.findById(flightEntity.getId());
		if (!flight.isPresent())
			return null;
		else
			return flight.get();
	}
	
	
}
