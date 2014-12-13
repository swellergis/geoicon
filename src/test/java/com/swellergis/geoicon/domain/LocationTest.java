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

	// exceptional case: x coordinate value is below minimum threshold for longitude (-180.0)
	@Test(expected = IllegalArgumentException.class)
	public void failIfXCoordinateIsBelowMinimumThreshold() {
		String errorCoord = Location.THRESHOLD_MIN_X + ".0001";
		location = new Location(errorCoord, "0", "0");
	}

	// exceptional case: y coordinate value is below minimum threshold for latitude (-90.0)
	@Test(expected = IllegalArgumentException.class)
	public void failIfYCoordinateIsBelowMinimumThreshold() {
		String errorCoord = Location.THRESHOLD_MIN_Y + ".0001";
		location = new Location("0", errorCoord, "0");
	}

	// exceptional case: z coordinate value is below minimum threshold for elevation
	@Test(expected = IllegalArgumentException.class)
	public void failIfZCoordinateIsBelowMinimumThreshold() {
		String errorCoord = Location.THRESHOLD_MIN_Z + ".0001";
		location = new Location("0", "0", errorCoord);
	}

}
