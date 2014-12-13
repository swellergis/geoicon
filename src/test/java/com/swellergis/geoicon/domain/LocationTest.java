package com.swellergis.geoicon.domain;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for 3D location objects.
 * 
 * @author Shaun
 *
 */
public class LocationTest {
	private Location location;
	private double expectedX;
	private double expectedY;
	private double expectedZ;
	
	@Before
	public void setup() {
		location = new Location();
	}
	
	// case: coordinate values defined as '0.0' yields a Location object with numeric
	// coordinate values equal to 0.0
	@Test
	public void defaultLocationIsZero() {
		expectedX = 0.0;
		expectedY = 0.0;
		expectedZ = 0.0;
		
		assertEquals(expectedX, location.getX());
		assertEquals(expectedY, location.getY());
		assertEquals(expectedZ, location.getZ());
	}

}
