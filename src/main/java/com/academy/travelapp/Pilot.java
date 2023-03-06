package com.academy.travelapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


// TODO:
// 2. FIX HQUERY STATEMENT 

public class Pilot extends Base implements Processor {

	private String name;
	private int rating;
	
	private static final String QUERY = "SELECT Id, make, model, years FROM Helicopter WHERE HelicopterId = '%s' ORDER BY Make";
	private static final String UPDATE = "UPDATE Pilot SET HelicopterId = '%s' WHERE Id = '%s')";
	private static final String WRITE = "INSERT INTO Pilot (Id, Name, Rating, YearsWithLicense) VALUES ('%s', '%s', '%s', %d)";

	private static final String SELECT = "SELECT Id FROM Pilot WHERE ";
	
	private List<Helicopter> helis;
	
	public Pilot(String name, int rating, int years) {
		super(years);
		this.name = name;
		this.rating = rating;
		this.write(String.format(WRITE, this.getId().toString(), this.name, this.rating, this.years));
	}
	
	// Getters	
	public String getName() {
		return this.name;
	}
	
	public int getRating() {
		return this.rating;
	}

	public List<Helicopter> getHelicopters() {
		return this.helis;	
	}
	
	public void process(ResultSet results) {
		try {
			while(results.next()) {
				
				String uuid = results.getString("Id");
				String make = results.getString("Make");
				String helicopterId = results.getString("HelicopterId");
			    int yearsWithLicense = results.getInt("YearsWithLicense");
			    
			    Helicopter helicopt = null;
			    
			    helicopt = new Helicopter(uuid, make, helicopterId, yearsWithLicense);

			    helis.add(helicopt);				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to process the results for a Pilot!");
		}
		
	}
}