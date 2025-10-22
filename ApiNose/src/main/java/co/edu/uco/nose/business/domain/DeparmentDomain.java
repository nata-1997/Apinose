package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DeparmentDomain extends Domain {
	
	private String name;
	private CountryDomain country;
	
	// Constructor
	public DeparmentDomain() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.getDefault());
		setCountry(new CountryDomain());
	}
	
	// Constructor con id
	public DeparmentDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountry(new CountryDomain());
	}
	
	// Constructor con atributos
	public DeparmentDomain(final UUID id, final String name, final CountryDomain country) {
		super(id);
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
	
	
	


}
