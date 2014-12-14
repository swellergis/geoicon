package com.swellergis.geoicon.domain;

/**
 * Class defining unprojected (geographic) 3D location objects.
 * 
 * @author Shaun
 *
 */
public class Location {
	// default coordinate value
	private static final String DEF_COORDINATE = "0";
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
	
	private double x; // longitude
	private double y; // latitude
	private double z; // elevation
	private String name;
	
	/**
	 * default constructor
	 */
	public Location() {
		// define default location to be 0, 0, 0
		this(DEF_COORDINATE, DEF_COORDINATE, DEF_COORDINATE);
	}
	/**
	 * Location constructor accepting longitude (x), latitude (y), and elevation (z) parameters.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Location(String x, String y, String z) {
		verifyCoordinateInput(x, y, z);
		this.x = Double.parseDouble(x);
		this.y = Double.parseDouble(y);
		this.z = Double.parseDouble(z);
	}

	// verify client input for coordinate values
	private void verifyCoordinateInput(String sx, String sy, String sz) {
		String errorMsg = null;

		// verify input for longitude is within the defined threshold range
		double dx = Math.abs(Double.parseDouble(sx));
		if (dx > THRESHOLD_MAX_X) {
			errorMsg = "Longitude (x) cannot be < " + THRESHOLD_MIN_X + " or > " + THRESHOLD_MAX_X + ". Input value: " + sx;
		}
		// verify input for latitude is within the defined threshold range
		double dy = Math.abs(Double.parseDouble(sy));
		if (dy > THRESHOLD_MAX_Y) {
			errorMsg = "Latitude (y) cannot be < " + THRESHOLD_MIN_Y + " or > " + THRESHOLD_MAX_Y + ". Input value: " + sy;
		}
		// verify input for elevation is below the defined minimum threshold
		double dz = Double.parseDouble(sz);
		if (dz < THRESHOLD_MIN_Z) {
			errorMsg = "Elevation (z) cannot be < " + THRESHOLD_MIN_Z + ". Input value: " + sz;
		}

		// throw an exception if there seems to be a problem
		if (errorMsg != null) {
			throw new IllegalArgumentException(errorMsg);
		}
	}

	// longitude
	public double getX() {
		return x;
	}
	// latitude
	public double getY() {
		return y;
	}
	// elevation
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
