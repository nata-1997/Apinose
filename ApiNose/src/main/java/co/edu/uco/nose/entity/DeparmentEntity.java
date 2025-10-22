package co.edu.uco.nose.entity;

import java.util.UUID;

public class DeparmentEntity {
	
	private UUID id;
    private CountryEntity country;
    private String name;
 
    // Default constructor
    public DeparmentEntity() {
        // Optional initial values
    }
 
    // Complete constructor
    public DeparmentEntity(final UUID id, final CountryEntity country, final String name) {
        this.id = id;
        this.country = country;
        this.name = name;
    }
 
    // Getters
    public UUID getId() {
        return id;
    }
 
    public CountryEntity getCountry() {
        return country;
    }
 
    public String getName() {
        return name;
    }
 
    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }
 
    public void setCountry(final CountryEntity country) {
        this.country = country;
    }
 
    public void setName(final String name) {
        this.name = name;
    }

}
