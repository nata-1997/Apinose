package co.edu.uco.nose.entity;

import java.util.UUID;

public class CountryEntity {
	
	private UUID id;
    private String name;
 
    // Default constructor
    public CountryEntity() {
        // Optional initial values
    }
 
    // Complete constructor
    public CountryEntity(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }
 
    // Getters
    public UUID getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    // Setters (optional, for mutability)
    public void setId(final UUID id) {
        this.id = id;
    }
 
    public void setName(final String name) {
        this.name = name;
    }
}


