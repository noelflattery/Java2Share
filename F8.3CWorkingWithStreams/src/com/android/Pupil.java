package com.android;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pupil implements Serializable{
	/*
	 * normally all of these values would be got from a database
	 */
	int id;
	String name;
	int age;
	static int counter;
	
	Set<Subject>subjectList=new HashSet<>();
	
	Pupil(){
		counter++;
		id=counter;
		name="pat";
		subjectList.addAll(Arrays.asList(Subject.ART,Subject.WOODWORK,Subject.HOME_ECONOMICS));
		age=(int)(Math.random())*10;
	}

	@Override
	public String toString() {
		return "Pupil [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
