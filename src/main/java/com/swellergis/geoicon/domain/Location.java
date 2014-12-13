package com.swellergis.geoicon.domain;

/**
 * Class defining unprojected (geographic) 3D location objects.
 * 
 * @author Shaun
 *
 */
public class Location {
	private static final String DEF_COORDINATE = "0";
	private double x;
	private double y;
	private double z;
	
	// default constructor
	public Location() {
		this(DEF_COORDINATE, DEF_COORDINATE, DEF_COORDINATE);
	}
	public Location(String x, String y, String z) {
		verifyCoordinateInput(x, y, z);
		this.x = Double.parseDouble(x);
		this.y = Double.parseDouble(y);
		this.z = Double.parseDouble(z);
	}

	// verify client input for coordinate values are valid
	private void verifyCoordinateInput(String sx, String sy, String sz) {
		double dx = Double.parseDouble(sx);
		if (dx < -180) {
			throw new IllegalArgumentException("Longitude (x) cannot be < -180. Input value: " + sx);
		}

		double dy = Double.parseDouble(sy);
		if (dy < -90) {
			throw new IllegalArgumentException("Latitude (y) cannot be < -90. Input value: " + sy);
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
	// altitude
	public double getZ() {
		return z;
	}

}
