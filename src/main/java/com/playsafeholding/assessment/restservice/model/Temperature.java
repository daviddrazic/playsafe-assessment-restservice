package com.playsafeholding.assessment.restservice.model;

import java.math.BigDecimal;

/**
 * POJO for storing and getting celsius to kelvin and vice versa mapping.
 * 
 * @author daviddrazic
 *
 */
public class Temperature {
	private BigDecimal celsius;
	private BigDecimal kelvin;
	
	public BigDecimal getCelsius() {
		return celsius;
	}
	
	public void setCelsius(BigDecimal celsius) {
		this.celsius = celsius;
		this.kelvin = this.celsius.add(new BigDecimal(273.15));
	}

	public void setKelvin(BigDecimal kelvin) {
		this.kelvin = kelvin;
		this.celsius = this.kelvin.subtract(new BigDecimal(273.15));
	}

	public BigDecimal getKelvin() {
		return kelvin;
	}
}
