package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;

public final class CityDomain extends Domain {
	
	private String name;
	private DeparmentDomain deparment;
	
	public CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDeparment(new DeparmentDomain	());
	}
	
	public CityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDeparment(new DeparmentDomain());
	}
	
	public CityDomain(final UUID id, final String name) {
		super(id);
		setName(name);
		setDeparment(new DeparmentDomain());
	}
	
	public CityDomain(final UUID id, final String name, final DeparmentDomain deparment) {
		super(id);
		setName(name);
		setDeparment(deparment);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeparmentDomain getDeparment() {
		return deparment;
	}

	public void setDeparment(DeparmentDomain deparment) {
		this.deparment = deparment;
	}
	


}
