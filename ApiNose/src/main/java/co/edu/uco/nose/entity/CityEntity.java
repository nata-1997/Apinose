package co.edu.uco.nose.entity;

import java.util.UUID;


public class CityEntity {
	
	private UUID id;
    private DeparmentEntity deparment;
    private String name;
 
    // Default constructor
    public CityEntity() {
        // Optional initial values
    }
 
    // Complete constructor
    public CityEntity(final UUID id, final DeparmentEntity deparment, final String name) {
        this.id = id;
        this.deparment = deparment;
        this.name = name;
    }
 
    // Getters
    public UUID getId() {
        return id;
    }
 
    public DeparmentEntity getDeparment() {
        return deparment;
    }
 
    public String getName() {
        return name;
    }
 
    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }
 
    public void setDeparment(final DeparmentEntity deparment) {
        this.deparment = deparment;
    }
 
    public void setName(final String name) {
        this.name = name;
    }
	
}
