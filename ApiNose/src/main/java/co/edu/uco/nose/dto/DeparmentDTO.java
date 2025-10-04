package co.edu.uco.nose.dto;

import java.util.UUID;

public class DeparmentDTO {
	
	private UUID id;
    private CountryDTO country;
    private String name;
 
    // Default constructor
    public DeparmentDTO() {
        // Optional initial values
    }
 
    // Complete constructor
    public DeparmentDTO(final UUID id, final CountryDTO country, final String name) {
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
