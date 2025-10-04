package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.dto.CountryDTO;

public class DeparmentEntity {
	
	private UUID id;
    private CountryDTO country;
    private String name;
 
    // Default constructor
    public DeparmentEntity() {
        // Optional initial values
    }
 
    // Complete constructor
    public DeparmentEntity(final UUID id, final CountryDTO country, final String name) {
        this.id = id;
        this.country = country;
        this.name = name;
    }
 
    // Getters
    public UUID getId() {
        return id;
    }
 
    public CountryDTO getCountry() {
        return country;
    }
 
    public String getName() {
        return name;
    }
 
    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }
 
    public void setCountry(final CountryDTO country) {
        this.country = country;
    }
 
    public void setName(final String name) {
        this.name = name;
    }

}
