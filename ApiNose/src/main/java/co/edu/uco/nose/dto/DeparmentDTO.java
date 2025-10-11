package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DeparmentDTO {
	
	private UUID id;
	private String name;
	private CountryDomain country;
	
	// Constructor
	public DeparmentDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(new CountryDomain());
	}
	
	// Constructor con id
	public DeparmentDTO(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setCountry(new CountryDomain());
	}
	
	// Constructor con atributos
	public DeparmentDTO(final UUID id, final String name, final CountryDomain country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	// Setter con validación
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryDomain getCountry() {
		return country;
	}

	public void setCountry(final CountryDomain country) {
		this.country = ObjectHelper.getDefault(country, new CountryDomain());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	
	
	


}
