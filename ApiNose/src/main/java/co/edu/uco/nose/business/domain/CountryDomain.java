package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

// Clase inmutable que representa el dominio de un país
public final class CountryDomain extends Domain{
	
	// Atributo
	private String name;
	
	// Constructor por defecto de la clase
	public CountryDomain() {
	// Llama al constructor de la clase padre con un UUID por defecto
		super(UUIDHelper.getUUIDHelper().getDefault());
	// Inicializa el nombre con un valor por defecto
		setName(TextHelper.getDefault());
	}
	
	// Constructor con id
	public CountryDomain(final UUID id) {
	// Llama al constructor de la clase padre con el UUID proporcionado
		super(id);
	// Inicializa el nombre con un valor por defecto
		setName(TextHelper.getDefault());
	}
	
	// Constructor con atributos
	public CountryDomain(final UUID id, final String name) {
	// Llama al constructor de la clase padre con el UUID proporcionado
		super(id);
	// Inicializa el nombre con el valor proporcionado
		setName(name);
	}
	
	// Getters and Setters
	public String getName() {
		// Retorna el nombre del país
		return name;
	}

	// Setter con validación para el nombre
	public void setName(final String name) {
		// Asigna el nombre, aplicando una validación para asegurar que no sea nulo o vacío
		
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	
}
