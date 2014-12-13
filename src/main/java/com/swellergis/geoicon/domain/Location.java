package com.swellergis.geoicon.domain;

/**
 * Class defining unprojected (geographic) 3D location objects.
 * 
 * @author Shaun
 *
 */
public class Location {
	// define default location at 0, 0, 0
	private static final String DEF_COORDINATE = "0";
	// minimum threshold for longitude (x)
	protected static final int THRESHOLD_MIN_X = -180;
	// minimum threshold for latitude (y)
	protected static final int THRESHOLD_MIN_Y = -90;
	// minimum threshold for elevation (z)
	protected static final int THRESHOLD_MIN_Z = -100;
	private double x;
	private double y;
	private double z;
	
	/**
	 * default constructor
	 */
	public Location() {
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

	// verify client input for coordinate values are valid
	private void verifyCoordinateInput(String sx, String sy, String sz) {
		String errorMsg = null;
		double dx = Double.parseDouble(sx);
		if (dx < THRESHOLD_MIN_X) {
			errorMsg = "Longitude (x) cannot be < " + THRESHOLD_MIN_X + ". Input value: " + sx;
		}

		double dy = Double.parseDouble(sy);
		if (dy < THRESHOLD_MIN_Y) {
			errorMsg = "Latitude (y) cannot be < " + THRESHOLD_MIN_Y + ". Input value: " + sy;
		}

		double dz = Double.parseDouble(sz);
		if (dz < THRESHOLD_MIN_Z) {
			errorMsg = "Elevation (z) cannot be < " + THRESHOLD_MIN_Z + ". Input value: " + sz;
		}

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

}
