package com.java.kafka.publisher.model;

public class DriverLocation {
	
	private String driverId;
	private double longtitude;
	private double latitude;
	private long timeStamp;
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "DriverLocation [driverId=" + driverId + ", longtitude=" + longtitude + ", latitude=" + latitude
				+ ", timeStamp=" + timeStamp + "]";
	}
	
	

}
