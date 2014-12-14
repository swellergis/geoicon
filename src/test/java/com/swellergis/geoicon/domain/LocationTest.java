package com.swellergis.geoicon.domain;

import static junit.framework.Assert.*;

import org.junit.After;
import org.junit.Assert;
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
	private String coordValid;
	private String coordError;

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

	// exceptional case: x coordinate value is outside valid range for longitude (-180 to 180)
	@Test(expected = IllegalArgumentException.class)
	public void failIfXCoordinateIsOutsideValidThresholdRange() {
		coordValid = "0";
		// x coordinate value is below minimum threshold for longitude (-180.0)
		coordError = Location.THRESHOLD_MIN_X + ".0001";
		location = new Location(coordError, coordValid, coordValid);
		// x coordinate value is above max threshold for longitude (180.0)
		coordError = Location.THRESHOLD_MAX_X + ".0001";
		location = new Location(coordError, coordValid, coordValid);
	}

	// exceptional case: y coordinate value is outside valid range for latitude (-90 to 90)
	@Test(expected = IllegalArgumentException.class)
	public void failIfYCoordinateIsOutsideValidThresholdRange() {
		coordValid = "0";
		// y coordinate value is below minimum threshold for latitude (-90.0)
		coordError = Location.THRESHOLD_MIN_Y + ".0001";
		location = new Location(coordValid, coordError, coordValid);
		// y coordinate value is above max threshold for latitude (90.0)
		coordError = Location.THRESHOLD_MAX_Y + ".0001";
		location = new Location(coordValid, coordError, coordValid);
	}

	// exceptional case: z coordinate value is below minimum threshold for elevation
	@Test(expected = IllegalArgumentException.class)
	public void failIfZCoordinateIsBelowMinimumThreshold() {
		coordValid = "0";
		coordError = Location.THRESHOLD_MIN_Z + ".0001";
		location = new Location(coordValid, coordValid, coordError);
	}
	
	// exceptional case: non-numeric (NaN) coordinate values
	@Test
	public void locationNameShowsErrorIfCoordinateValueIsNonNumeric() {
		coordValid = "0";
		coordError = "";
		location = new Location(coordValid, coordValid, coordError);
		assertTrue(location.getName().equals(Location.ERROR_NAME));
	}

}
