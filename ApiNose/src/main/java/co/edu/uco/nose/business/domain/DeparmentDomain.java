package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DeparmentDomain extends Domain {
	
	private String name;
	private CountryDomain country;
	
	// Constructor
	public DeparmentDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	// Constructor con id
	public DeparmentDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	
	// Constructor con atributos
	public DeparmentDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	// Setter con validación
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	


}
