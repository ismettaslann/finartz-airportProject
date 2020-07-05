package finartz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import finartz.entity.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, Integer>{

}
