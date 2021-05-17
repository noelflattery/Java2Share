package com.android;

public class PrintData implements Runnable{

	static int count=0;
	@Override
	public void run() {
		System.out.println("before loop");
		for(int i=0;i<10;i++,count++) {
			System.out.println("count is "+count);
		}
		
	}

}
