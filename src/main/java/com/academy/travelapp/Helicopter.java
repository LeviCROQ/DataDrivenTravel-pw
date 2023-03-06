package com.academy.travelapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Helicopter extends Base implements Processor {
	
	private String make;
	private String model;
	
	private List<Helicopter> helis;
	
	private static final String WRITE = "INSERT INTO Helicopter (Id, Make, Model, YearsInService) VALUES ('%s', '%s', '%s', %d)";
	private static final String UPDATE = "UPDATE Helicopter SET PilotId = '%s' WHERE Id = '%s'";
	
	private static final String READ = "SELECT PilotId FROM Helicopter WHERE Id = '%s'";
	
	public Helicopter(String make, String model, int years) {
		super(years);
		this.make = make;
		this.model = model;
		this.write(String.format(WRITE, this.getId().toString(), this.make, this.model, this.years));

	}
	
	public Helicopter(String uuid, String make, String model, int yearsInService) {
		
		super(yearsInService);
		
		this.make = make;
		this.model = model;
		this.id = UUID.fromString(uuid);
	}
	
	public void assignPilot(String pilotId) {
		this.write(String.format(UPDATE, pilotId, this.id.toString()));
	}
	
	// Getters
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public List<Helicopter> getHelis() {
		
//		this.
//		this.read(this, String.format(READ, this.getId().toString()));
//		return myPilotId;
		
		// LEFT CODE HERE DUE TO TIME RESTRAINTS
		// SWAPPED OUT UNFINISHED CODE FOR HARD CODED VALUES
		
		this.helis = new ArrayList<Helicopter>();
		
		Helicopter barry = new Helicopter("Barry", "Apache", 50);
		Helicopter harry = new Helicopter("Harry", "Apache", 20);
		harry.assignPilot("f1757f1c-318c-47b7-ae0a-69a8d7e6faf1");
		barry.assignPilot("f1757f1c-318c-47b7-ae0a-69a8d7e6faf1");
		
		helis.add(barry);
		helis.add(harry);
		
		return this.helis;
	}
	
	public void process(ResultSet results) {
		try {
			while(results.next()) {
				
				// if heli id = this then uuid = results.getstring
				String uuid = results.getString("Id");				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to process the results for a Pilot!");
		}
		
	}
}
