package com.swellergis.geoicon.domain;

/**
 * Class defining an unprojected (geographic) 3D location object.
 * 
 * @author Shaun
 *
 */
public class Location {
	// default coordinate value
	private static final String DEF_COORDINATE = "0";
	// TODO create an enum to hold valid x/y/z range values
	// min/max thresholds for longitude (x)
	protected static final int THRESHOLD_MIN_X = -180;
	protected static final int THRESHOLD_MAX_X = 180;
	// min/max thresholds for latitude (y)
	protected static final int THRESHOLD_MIN_Y = -90;
	protected static final int THRESHOLD_MAX_Y = 90;
	// minimum threshold for elevation (z)
	protected static final int THRESHOLD_MIN_Z = -100;
	// name given to locations with invalid coordinate values
	protected static final String ERROR_NAME = "location_error";
	// name given to locations created through default constructor (no parameters)
	protected static final String DEFAULT_NAME = "location_default";

	private double x; // longitude
	private double y; // latitude
	private double z; // elevation
	private String name;
	
	public Location() {
		// define default location to be 0, 0, 0
		this(DEF_COORDINATE, DEF_COORDINATE, DEF_COORDINATE);
	}
	/**
	 * @param x - longitude
	 * @param y - latitude
	 * @param z - elevation
	 */
	public Location(String x, String y, String z) {
		name = DEFAULT_NAME;
		parseCoordinateInput(x, y, z);
	}

	/**
	 * Attempt to parse input coordinate string values into numeric types.
	 * 
	 * @param sx - longitude (x) string value
	 * @param sy - latitude (y) string value
	 * @param sz - elevation (z) string value
	 */
	private void parseCoordinateInput(String sx, String sy, String sz) {		
		try {
			x = Math.abs(Double.parseDouble(sx));
			y = Math.abs(Double.parseDouble(sy));
			z = Double.parseDouble(sz);
		} catch(NumberFormatException e) {
			// TODO implement logging
			String errorMsg = String.format("Parameters for input coordinates must be numeric. Input values: %s, %s, %s", sx, sy, sz);
			defineWithDefaultCoordinates(ERROR_NAME);
		}
		verifyCoordinateInput(x, y, z);
	}
	
	/**
	 * Define location with default coordinate values.
	 * 
	 * @param locName - location name value
	 */
	private void defineWithDefaultCoordinates(String locName) {
		double defaultCoordinate = Double.parseDouble(DEF_COORDINATE);
		x = defaultCoordinate;
		y = defaultCoordinate;
		z = defaultCoordinate;
		name = locName;
	}
	
	/**
	 * Verify client input for coordinate values are within valid range
	 * 
	 * @param dx - longitude (x) numeric value
	 * @param dy - latitude (y) numeric value
	 * @param dz - elevation (z) numeric value
	 */
	private void verifyCoordinateInput(double dx, double dy, double dz) {
		StringBuilder errorMsg = new StringBuilder("");

		// verify input for longitude is within the defined threshold range
		if (dx > THRESHOLD_MAX_X) {
			errorMsg.append("Longitude (x) cannot be < " + THRESHOLD_MIN_X + " or > " + THRESHOLD_MAX_X + ". Input value: " + dx);
		}
		// verify input for latitude is within the defined threshold range
		if (dy > THRESHOLD_MAX_Y) {
			errorMsg.append("Latitude (y) cannot be < " + THRESHOLD_MIN_Y + " or > " + THRESHOLD_MAX_Y + ". Input value: " + dy);
		}
		// verify input for elevation is below the defined minimum threshold
		if (dz < THRESHOLD_MIN_Z) {
			errorMsg.append("Elevation (z) cannot be < " + THRESHOLD_MIN_Z + ". Input value: " + dz);
		}

		// log an error if there seems to be a problem and define location with default coordinates
		if (!errorMsg.toString().isEmpty()) {
			defineWithDefaultCoordinates(ERROR_NAME);
		}
	}

	/**
	 * @return the longitude x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @return the latitude y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @return the elevation z
	 */
	public double getZ() {
		return z;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
