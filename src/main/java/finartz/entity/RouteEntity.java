package finartz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
public class RouteEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "departureAirportID")
	private String departureAirportID;
	
	@Column(name = "arrivalAirportID")
	private String arrivalAirportID;
	
	public RouteEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureAirportID() {
		return departureAirportID;
	}

	public void setDepartureAirportID(String departureAirportID) {
		this.departureAirportID = departureAirportID;
	}

	public String getArrivalAirportID() {
		return arrivalAirportID;
	}

	public void setArrivalAirportID(String arrivalAirportID) {
		this.arrivalAirportID = arrivalAirportID;
	}

	public RouteEntity(int id, String departureAirportID, String arrivalAirportID) {
		super();
		this.id = id;
		this.departureAirportID = departureAirportID;
		this.arrivalAirportID = arrivalAirportID;
	}

	

	
}
