package com.money;

public class UsTaxCode {
	double rate;
	String band;
	
	UsTaxCode(){
		rate=12.5;
		band="ab";
	}
	
	public String toString() {
		return "USA rate is "+rate+" band is "+band;
	}

}
