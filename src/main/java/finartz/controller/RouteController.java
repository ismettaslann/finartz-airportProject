 package finartz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finartz.common.CommonResponse;
import finartz.constants.ResponseCodes;
import finartz.dao.RouteRepository;
import finartz.entity.RouteEntity;

@RestController
@RequestMapping(value = "/routes")
public class RouteController {

	@Autowired
	private RouteRepository routeRepository;
	
	@PostMapping(path = "/createRoute")
	public CommonResponse createAirport(@RequestBody RouteEntity routeEntity) {
		CommonResponse response = new CommonResponse();
		if (routeEntity.getDepartureAirportID().equals("") || routeEntity.getArrivalAirportID().equals("")) {
			response.setResponseCode(ResponseCodes.FIELD_EMPTY_CODE);
			response.setResponseMessage(ResponseCodes.FIELD_EMPTY_MESSAGE);
			return response;
		}
		routeRepository.save(routeEntity);
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		response.setResponseMessage(ResponseCodes.SUCCESFUL_RESPONSE_MESSAGE);
		return response;
	}
	
	@PostMapping(path = "/listRoutes")
	public List < RouteEntity > listAllRoutes() {
		return routeRepository.findAll();
	}
	
	@PostMapping(path = "/getRoute")
	public List < RouteEntity > getRoute (@RequestBody RouteEntity routeEntity) {
		return routeRepository.findByDepartureAirportIDAndArrivalAirportID(routeEntity.getDepartureAirportID(), routeEntity.getArrivalAirportID());
	}
}
