package finartz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import finartz.entity.AirlinesEntity;

public interface AirlinesRepository extends JpaRepository<AirlinesEntity, Integer>{

	List<AirlinesEntity> findByAirlineName(String airlineName);

}
