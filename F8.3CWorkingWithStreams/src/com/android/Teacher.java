package com.android;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable{
	
	int id;
	String name;
	int age;
	double wage;
	static int counter;
	
	Set<Subject>teacherSubjects=new HashSet<>();
	
	Teacher(){
		counter++;
		id=counter;
		name="ms Rita Lally";
		age=(int)(Math.random()+1)*100;
		wage=1000.00;
		teacherSubjects.addAll(Arrays.asList(Subject.ART,Subject.WOODWORK,Subject.HOME_ECONOMICS));
	}
	
	void teach() {
		System.out.println("teacher teaching");
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", wage=" + wage + "]";
	}
	

}
