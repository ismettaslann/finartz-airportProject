package finartz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import finartz.entity.AirportEntity;


public interface AirportRepository extends JpaRepository<AirportEntity, Integer>{

	List<AirportEntity> findByAirportName(String airportName);

	List<AirportEntity> findByAirportCode(String airportName);

}
