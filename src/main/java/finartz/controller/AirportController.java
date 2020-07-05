package finartz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finartz.common.CommonResponse;
import finartz.constants.ResponseCodes;
import finartz.dao.AirportRepository;
import finartz.entity.AirportEntity;

@RestController
@RequestMapping(value = "/airports")
public class AirportController {

	@Autowired
	private AirportRepository airportRepository;
	
	@PostMapping(path = "/createAirport")
	public CommonResponse createAirport(@RequestBody AirportEntity airportEntity) {
		CommonResponse response = new CommonResponse();
		if (airportEntity.getAirportCode().equals("") || airportEntity.getAirportName().equals("")) {
			response.setResponseCode(ResponseCodes.FIELD_EMPTY_CODE);
			response.setResponseMessage(ResponseCodes.FIELD_EMPTY_MESSAGE);
			return response;
		}
		airportRepository.save(airportEntity);
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		response.setResponseMessage(ResponseCodes.SUCCESFUL_RESPONSE_MESSAGE);
		return response;
	}
	
	@PostMapping(path = "/listAirports")
	public List < AirportEntity > listAllAirports () {
		return airportRepository.findAll();
	}
	
	@PostMapping(path = "/getAirportByCode/{airportCode}")
	public List < AirportEntity > getAirport (@PathVariable String airportCode) {
		return airportRepository.findByAirportCode(airportCode);
	}
}
