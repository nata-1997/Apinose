package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.dto.DeparmentDTO;

public class CityEntity {
	
	private UUID id;
    private DeparmentDTO deparment;
    private String name;
 
    // Default constructor
    public CityEntity() {
        // Optional initial values
    }
 
    // Complete constructor
    public CityEntity(final UUID id, final DeparmentDTO department, final String name) {
        this.id = id;
        this.deparment = department;
        this.name = name;
    }
 
    // Getters
    public UUID getId() {
        return id;
    }
 
    public DeparmentDTO getDepartment() {
        return deparment;
    }
 
    public String getName() {
        return name;
    }
 
    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }
 
    public void setDepartment(final DeparmentDTO department) {
        this.deparment = department;
    }
 
    public void setName(final String name) {
        this.name = name;
    }
	
}
