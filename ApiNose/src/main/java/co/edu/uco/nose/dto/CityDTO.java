package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;

public final class CityDTO {
	
	private UUID id;
	private String name;
	private DeparmentDTO deparment;
	
	public CityDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDeparment(new DeparmentDTO());
	}
	
	public CityDTO(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setDeparment(new DeparmentDTO());
	}
	
	public CityDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
		setDeparment(new DeparmentDTO());
	}
	
	public CityDTO(final UUID id, final String name, final DeparmentDTO deparment) {
		setId(id);
		setName(name);
		setDeparment(deparment);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeparmentDTO getDeparment() {
		return deparment;
	}

	public void setDeparment(DeparmentDTO deparment) {
		this.deparment = ObjectHelper.getDefault(deparment, new DeparmentDTO());
	}
	


}
