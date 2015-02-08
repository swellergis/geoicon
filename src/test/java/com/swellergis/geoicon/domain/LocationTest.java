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
	private Location locationDefault;
	private double expectedX;
	private double expectedY;
	private double expectedZ;
	private String expectedName;
	private String expectedStringValue;
	private String coordValid;
	private String coordError;

	@Before
	public void setup() {
		locationDefault = new Location();
	}
	@After
	public void teardown() {
		locationDefault = null;
		expectedX = 0;
		expectedY = 0;
		expectedZ = 0;
		expectedName = null;
		expectedStringValue = null;
		coordValid = null;
		coordError = null;
	}
	
	// case: coordinate values defined as '0.0' yields a Location object with numeric
	// coordinate values equal to 0.0
	@Test
	public void defaultLocationIsZero() {
		expectedX = 0.0;
		expectedY = 0.0;
		expectedZ = 0.0;
		
		assertEquals(expectedX, locationDefault.getX());
		assertEquals(expectedY, locationDefault.getY());
		assertEquals(expectedZ, locationDefault.getZ());
	}

	// case: x coordinate value is outside valid range for longitude (-180 to 180)
	@Test
	public void locationNameShowsErrorfXCoordinateIsOutsideValidThresholdRange() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";
		
		// x coordinate value is below minimum threshold for longitude (-180.0)
		coordError = Location.THRESHOLD_MIN_X + ".0001";
		locationDefault = new Location(coordError, coordValid, coordValid);
		assertEquals(expectedName, locationDefault.getName());
		// x coordinate value is above max threshold for longitude (180.0)
		coordError = Location.THRESHOLD_MAX_X + ".0001";
		locationDefault = new Location(coordError, coordValid, coordValid);
		assertEquals(expectedName, locationDefault.getName());
	}

	// case: y coordinate value is outside valid range for latitude (-90 to 90)
	@Test
	public void locationNameShowsErrorIfYCoordinateIsOutsideValidThresholdRange() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";
		
		// y coordinate value is below minimum threshold for latitude (-90.0)
		coordError = Location.THRESHOLD_MIN_Y + ".0001";
		locationDefault = new Location(coordValid, coordError, coordValid);
		assertEquals(expectedName, locationDefault.getName());
		// y coordinate value is above max threshold for latitude (90.0)
		coordError = Location.THRESHOLD_MAX_Y + ".0001";
		locationDefault = new Location(coordValid, coordError, coordValid);
		assertEquals(expectedName, locationDefault.getName());
	}

	// case: z coordinate value is below minimum threshold for elevation
	@Test
	public void locationNameShowsErrorIfZCoordinateIsBelowMinimumThreshold() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";

		coordError = Location.THRESHOLD_MIN_Z + ".0001";
		locationDefault = new Location(coordValid, coordValid, coordError);
		assertEquals(expectedName, locationDefault.getName());
	}
	
	// case: non-numeric (NaN) coordinate values
	@Test
	public void locationNameShowsErrorIfCoordinateValueIsNonNumeric() {
		expectedName = Location.ERROR_NAME;
		coordValid = "0";
		coordError = "";

		locationDefault = new Location(coordValid, coordValid, coordError);
		assertEquals(expectedName, locationDefault.getName());
		locationDefault = new Location(coordValid, coordError, coordValid);
		assertEquals(expectedName, locationDefault.getName());
		locationDefault = new Location(coordError, coordValid, coordValid);
		assertEquals(expectedName, locationDefault.getName());
	}
	
	// (n) case: a location created with valid input coordinate values yields an
	// object whose coordinates are valid numeric representations of the input.
	@Test
	public void validInputStringCoordinatesYieldRepresentativeNumericCoordinates() {
		coordValid = "10.501";
		expectedX = Double.parseDouble(coordValid);
		expectedY = Double.parseDouble(coordValid);
		expectedZ = Double.parseDouble(coordValid);

		locationDefault = new Location(coordValid, coordValid, coordValid);
		assertEquals(expectedX, locationDefault.getX());
		assertEquals(expectedY, locationDefault.getY());
		assertEquals(expectedZ, locationDefault.getZ());
	}
	
	// case: two distinct location objects created with default coordinates are 
	// considered to be equal.
	@Test
	public void twoDefaultLocationsAreEqual() {
		// this assert invokes the equals method on the first object against the second
		assertEquals(locationDefault, new Location());
	}
	
	// case: the toString() method returns a descriptive value that is what the user 
	// would expect to see.
	@Test
	public void locationToStringIsDescriptive() {
		expectedX = 0.0;
		expectedY = 0.0;
		expectedZ = 0.0;
		expectedName = Location.DEFAULT_NAME;
		expectedStringValue = 
				String.format("[Location: %s, %s, %s, %s]", expectedName, expectedX, expectedY, expectedZ);
		assertTrue(locationDefault.toString().equals(expectedStringValue));
	}
	
	// case: location objects are sorted according to name.
	@Test
	public void locationsAreSortedByName() {
		
	}

}
