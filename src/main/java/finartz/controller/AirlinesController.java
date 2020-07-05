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
import finartz.dao.AirlinesRepository;
import finartz.entity.AirlinesEntity;

@RestController
@RequestMapping(value = "/airlines")
public class AirlinesController {
	
	@Autowired
	private AirlinesRepository airlinesRepository;
	
	
	@PostMapping(path = "/createAirlines")
	public CommonResponse createAirlines (@RequestBody AirlinesEntity airlines) {
		CommonResponse response = new CommonResponse();
		if(airlines.getAirlineName().equals("")) {
			response.setResponseCode(ResponseCodes.FIELD_EMPTY_CODE);
			response.setResponseMessage(ResponseCodes.FIELD_EMPTY_MESSAGE);
			return response;
		}
		airlinesRepository.save(airlines);
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		response.setResponseMessage(ResponseCodes.SUCCESFUL_RESPONSE_MESSAGE);
		return response;
	}
	
	@PostMapping(path = "/listAllAirlines")
	public List < AirlinesEntity > listAllAirlines () {
		return airlinesRepository.findAll();
	}
	
	@PostMapping(path = "/getAirline/{airlineName}")
	public List < AirlinesEntity > getAirline (@PathVariable String airlineName) {
		return airlinesRepository.findByAirlineName(airlineName);
	}
	
	
}
