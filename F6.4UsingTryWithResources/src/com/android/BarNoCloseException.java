package com.android;



public class BarNoCloseException extends RuntimeException{

	BarNoCloseException(){
		System.out.println("BarNoCloseException created");
	}
}
