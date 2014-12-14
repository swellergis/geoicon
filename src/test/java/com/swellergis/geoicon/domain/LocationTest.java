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
	private String expectedName;
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

	// case: x coordinate value is outside valid range for longitude (-180 to 180)
	@Test
	public void locationNameShowsErrorfXCoordinateIsOutsideValidThresholdRange() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";
		
		// x coordinate value is below minimum threshold for longitude (-180.0)
		coordError = Location.THRESHOLD_MIN_X + ".0001";
		location = new Location(coordError, coordValid, coordValid);
		assertEquals(expectedName, location.getName());
		// x coordinate value is above max threshold for longitude (180.0)
		coordError = Location.THRESHOLD_MAX_X + ".0001";
		location = new Location(coordError, coordValid, coordValid);
		assertEquals(expectedName, location.getName());
	}

	// case: y coordinate value is outside valid range for latitude (-90 to 90)
	@Test
	public void locationNameShowsErrorIfYCoordinateIsOutsideValidThresholdRange() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";
		
		// y coordinate value is below minimum threshold for latitude (-90.0)
		coordError = Location.THRESHOLD_MIN_Y + ".0001";
		location = new Location(coordValid, coordError, coordValid);
		assertEquals(expectedName, location.getName());
		// y coordinate value is above max threshold for latitude (90.0)
		coordError = Location.THRESHOLD_MAX_Y + ".0001";
		location = new Location(coordValid, coordError, coordValid);
		assertEquals(expectedName, location.getName());
	}

	// case: z coordinate value is below minimum threshold for elevation
	@Test
	public void locationNameShowsErrorIfZCoordinateIsBelowMinimumThreshold() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";

		coordError = Location.THRESHOLD_MIN_Z + ".0001";
		location = new Location(coordValid, coordValid, coordError);
		assertEquals(expectedName, location.getName());
	}
	
	// case: non-numeric (NaN) coordinate values
	@Test
	public void locationNameShowsErrorIfCoordinateValueIsNonNumeric() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";
		coordError = "";

		location = new Location(coordValid, coordValid, coordError);
		assertEquals(expectedName, location.getName());
		location = new Location(coordValid, coordError, coordValid);
		assertEquals(expectedName, location.getName());
		location = new Location(coordError, coordValid, coordValid);
		assertEquals(expectedName, location.getName());
	}

}
