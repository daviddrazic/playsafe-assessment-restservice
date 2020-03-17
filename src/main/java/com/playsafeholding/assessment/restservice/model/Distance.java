package com.playsafeholding.assessment.restservice.model;

import java.math.BigDecimal;

/**
 * POJO for storing and getting kilometers to miles and vice versa mapping.
 * 
 * @author daviddrazic
 *
 */
public class Distance {
	private BigDecimal kilometers;
	private BigDecimal miles;
	
	public BigDecimal getKilometers() {
		return kilometers;
	}
	
	public void setKilometers(BigDecimal kilometers) {
		this.kilometers = kilometers;
		this.miles = this.kilometers.divide(new BigDecimal(1.609344));
	}

	public void setMiles(BigDecimal miles) {
		this.miles = miles;
		this.kilometers = this.miles.multiply(new BigDecimal(1.609344));
	}

	public BigDecimal getMiles() {
		return miles;
	}
}
