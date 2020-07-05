package finartz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import finartz.entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{

	List<TicketEntity> findByTicketNumber(String ticketNumber);

}
