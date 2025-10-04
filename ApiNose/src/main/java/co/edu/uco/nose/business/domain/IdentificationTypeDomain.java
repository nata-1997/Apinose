package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

	// Clase inmutable que representa el dominio del Tipo de Identificación
public  final class IdentificationTypeDomain extends Domain {
	
	// Atributo de la entidad Tipo de Identificación
	private String name;
	
	// Constructor por defecto de la clase
	public IdentificationTypeDomain() {
		// Llama al constructor de la clase padre con un UUID por defecto
		super(UUIDHelper.getUUIDHelper().getDefault());
		// Inicializa el nombre con un valor por defecto
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDomain(final UUID id) {
		// Llama al constructor de la clase padre con el UUID proporcionado
		super(id);
		// Inicializa el nombre con un valor por defecto
		setName(TextHelper.getDefault());
	}
	
	
	// Constructor con atributos de la entidad
	public IdentificationTypeDomain(final UUID id, final String name) {
		// Llama al constructor de la clase padre con el UUID proporcionado
		super(id);
		// Inicializa el nombre con el valor proporcionado
		setName(name);
	}
	
	// Getters and Setters
	public String getName() {
		// Retorna el nombre del tipo de identificación
		return name;
	}
	
	// Setter con validación para el nombre
	public void setName(final String name) {
		// Asigna el nombre, aplicando una validación para asegurar que no sea nulo o vacío
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	

}
