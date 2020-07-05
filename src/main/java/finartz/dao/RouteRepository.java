package finartz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import finartz.entity.RouteEntity;

public interface RouteRepository  extends JpaRepository<RouteEntity, Integer>{

	List<RouteEntity> findByDepartureAirportIDAndArrivalAirportID(String departureAirportID, String arrivalAirportID);

}
