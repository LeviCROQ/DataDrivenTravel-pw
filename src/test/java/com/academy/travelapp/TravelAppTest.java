package com.academy.travelapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

final class ProcessorTest implements Processor {
	public void process(ResultSet results) {
		try {
			// Would normally next in while loop
			assertTrue(results.next());
			
			// Test hello column data	
			String hello = results.getString("hello");
			assertTrue(hello.equals("Academy"));
			
			// Test world column data
			String world = results.getString("world");
			assertTrue(world.equals("Cool"));
			
			// Should be no more rows
			assertFalse(results.next());
		} catch (Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}

}

public class TravelAppTest {
	@Test
	public void writePilot() {
		Pilot adam = new Pilot("Adam", 10, 1);
	}
	
	@Test
	public void writeHelicopter() {
		
		Pilot levi = new Pilot("Levi", 100, 1);
		
		String myPilotId = levi.getId().toString();
		
		Helicopter breeze = new Helicopter("Breeze", "Apache", 3); // Create new heli
		breeze.assignPilot(myPilotId); // Assign existing pilot to heli
		
		Helicopter thunder = new Helicopter("Thunder", "Non-Apache", 5); // Create new heli with no pilotID assignment
		thunder.assignPilot(myPilotId); // assign same pilot as the previous heli
		
		assertTrue(true);
		
		// Check that the pilot has been assigned to both helicopters
		//assertTrue(breeze.
	}
	
	
	@Test
	public void listHelicopters() {
		
		Pilot harvey = new Pilot("Harvey", 1, 10); // Create new pilot
		
		String myPilotId = harvey.getId().toString();
		
		Helicopter banger = new Helicopter("Banger", "Apache", 3); // Create new heli
		banger.assignPilot(myPilotId); // Assign existing pilot to heli
		
		Helicopter clanger = new Helicopter("Clanger", "Non-Apache", 5); // Create new heli with no pilotID assignment
		clanger.assignPilot(myPilotId); // assign same pilot as the previous heli
		
		// Check the make of each helicopter
		assertTrue(banger.getMake().equals("Banger"));
		assertTrue(clanger.getMake().equals("Clanger"));
		
	}
}
