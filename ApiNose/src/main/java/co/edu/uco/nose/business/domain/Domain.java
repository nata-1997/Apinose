package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

class Domain {
	// Atributo
	private UUID id;
	
	// Constructor
	protected Domain( final UUID id) {
		setId(id);
		
	}

	// Getters and Setters
	public UUID getId() {
		return id;
	}

	// Setter con validación
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
		

}
