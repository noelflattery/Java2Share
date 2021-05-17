package com.android.animals;

public class Test2 /*implements Cloneable*/ {
	private int num;
	private String str;
	
	public Test2(int num,String str) {
		this.num=num;
		this.str=str;
	}
	@Override
	 public Test2 clone() throws
     CloneNotSupportedException 
{ 
	/*	Test2 t = (Test2)super.clone(); */
		Test2 t=new Test2(num,str);
		t=new Test2(num,str);
		
		return t;
} 
	

}




