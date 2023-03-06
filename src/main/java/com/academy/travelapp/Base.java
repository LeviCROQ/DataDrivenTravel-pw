package com.academy.travelapp;

import java.util.UUID;

public class Base {
	
	protected UUID id;
	protected int years;
	
	public Base(int years) {
		this.id = UUID.randomUUID();
		this.years = years;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public int getYears() {
		return this.years;
	}

	public void write(String sql) {
		try (/*TravelAppDB db = new TravelAppDB(); */ TravelApp app = new TravelApp()) {			
			app.write(sql);
		}
	}
	
	public void read(Processor processor, String sql) {
		try(TravelApp app = new TravelApp()) {
			app.read(processor, sql);
		}
	}
}
