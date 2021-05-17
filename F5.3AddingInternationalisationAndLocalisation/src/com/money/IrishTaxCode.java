package com.money;

public class IrishTaxCode {
	
	double rate;
	String band;
	
	IrishTaxCode(){
		rate=22.5;
		band="CDF";
	}
	
	public String toString() {
		return "irish rate is "+rate+" irish band is "+band;
	}

}
