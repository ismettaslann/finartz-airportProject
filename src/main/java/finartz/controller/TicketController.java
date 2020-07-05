package finartz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finartz.common.CommonResponse;
import finartz.common.CommonServices;
import finartz.constants.ResponseCodes;
import finartz.dao.FlightRepository;
import finartz.dao.TicketRepository;
import finartz.entity.FlightEntity;
import finartz.entity.TicketEntity;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@PostMapping(path = "/newTicketPayment")
	public CommonResponse newTicketPayment (@RequestBody TicketEntity ticketEntity) {
		CommonServices services = new CommonServices();
		CommonResponse response = new CommonResponse();
		FlightEntity flight = null;
		
		if(ticketEntity.getCardNumber().isEmpty() || ticketEntity.getPassengerIdendityNumber().isEmpty() || 
		   ticketEntity.getPassengerName().isEmpty() || ticketEntity.getFlightId().toString().isEmpty()) {
			response.setResponseCode(ResponseCodes.FIELD_EMPTY_CODE);
			response.setResponseMessage(ResponseCodes.FIELD_EMPTY_MESSAGE);
			return response;
		}
		
		
		if(!flightRepository.findById(ticketEntity.getFlightId()).isPresent()) {
			response.setResponseCode(ResponseCodes.ROUTE_NOT_FOUND_CODE);
			response.setResponseMessage(ResponseCodes.ROUTE_NOT_FOUND_MESSAGE);
			return response;
		}
		else {
			flight = flightRepository.findById(ticketEntity.getFlightId()).get();
		}
		
		if(flight.getRemainSeatCount() == 0) {
			response.setResponseCode(ResponseCodes.REMAING_SEATS_EMPTY_CODE);
			response.setResponseMessage(ResponseCodes.ROUTE_REMAIN_SEATS_EMPTY_MESSAGE);
			return response;
		}
		ticketEntity.setTicketNumber(services.generateTicketNumber());
		ticketEntity.setCardNumber(services.maskCardNumber(ticketEntity.getCardNumber()));
		ticketEntity.setStatus("1");
		ticketRepository.save(ticketEntity);
		flight.setRemainSeatCount(flight.getRemainSeatCount() - 1);
		flight.setPrice(services.calculatePriceByPercentage(flight.getSeatCount(), flight.getRemainSeatCount(), flight.getPrice()));
		flightRepository.save(flight);
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		response.setResponseMessage(ResponseCodes.SUCCESFUL_RESPONSE_MESSAGE);
		return response;
	}
	
	@PostMapping(path = "/searchTicketByTicketNumber")
	public List <TicketEntity> searchTicketByTicketNumber (@RequestBody TicketEntity ticketEntity) {
		return ticketRepository.findByTicketNumber(ticketEntity.getTicketNumber());
	}
	
	@PostMapping(path = "/cancelTicket")
	public CommonResponse cancelTicket(@RequestBody TicketEntity ticketEntity) {
		CommonResponse response = new CommonResponse();
		FlightEntity flight = new FlightEntity();
		Optional<TicketEntity> ticketQuery = ticketRepository.findById(ticketEntity.getId());
		if(!ticketQuery.isPresent()) {
			response.setResponseCode(ResponseCodes.TICKET_NOT_FOUND_CODE);
			response.setResponseMessage(ResponseCodes.TICKET_NOT_FOUND_MESSAGE);
			return response;
		}
		ticketEntity = ticketQuery.get();

		if(!flightRepository.findById(ticketEntity.getFlightId()).isPresent()) {
			response.setResponseCode(ResponseCodes.ROUTE_NOT_FOUND_CODE);
			response.setResponseMessage(ResponseCodes.ROUTE_NOT_FOUND_MESSAGE);
			return response;
		}
		else {
			flight = flightRepository.findById(ticketEntity.getFlightId()).get();
		}
		
		flight.setRemainSeatCount(flight.getRemainSeatCount() + 1);
		flightRepository.save(flight);
		ticketEntity.setStatus("0");
		ticketRepository.save(ticketEntity);
		response.setResponseCode(ResponseCodes.SUCCESSFUL_RESPONSE_CODE);
		response.setResponseMessage(ResponseCodes.SUCCESFUL_RESPONSE_MESSAGE);
		return response;
	}
	
	
	@PostMapping(path = "/listAllTickets")
	public List < TicketEntity > listAllTickets () {
		return ticketRepository.findAll();
	}
	
}
