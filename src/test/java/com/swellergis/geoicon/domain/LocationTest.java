package com.swellergis.geoicon.domain;

import static junit.framework.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for 3D Location objects.
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
	@After
	public void teardown() {
		location = null;
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

	// exceptional case: x coordinate value is below minimum threshold (-180.0)
	@Test(expected = IllegalArgumentException.class)
	public void failIfXCoordinateIsBelowMinimumThreshold() {
		location = new Location("-180.0001", "0", "0");
	}

	// exceptional case: y coordinate value is below minimum threshold (-90.0)
	@Test(expected = IllegalArgumentException.class)
	public void failIfYCoordinateIsBelowMinimumThreshold() {
		location = new Location("0", "-90.0001", "0");
	}

}
