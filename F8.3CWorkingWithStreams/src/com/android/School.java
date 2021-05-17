package com.android;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class School implements Serializable{
	/*
	 * all classes that are referred to inside the School clas also have to implement the Serializable
	 * interface.
	 * So Teacher, Pupil and subjects of each school, those classe have to implment serializable interface
	 * Any object of a class that does not implement the serializable interface has to be marked as
	 * Transient
	 */
	String name;//name of school
	
	LocalTime start;//the time the school starts
	//this will not be serialized as it's a static
	static int counter;
	//this unique id for each school will be serialized, which is calculated from the static int counter
	int schoolId;
	/*
	 * this will be used to uniquely identify the serialized file, as each file will
	 * have a different DateTime
	 * this value is NOT serialized, as it's a static
	 */
	private static final LocalDateTime rightNow=LocalDateTime.now();//NOT serialized
	/*
	 * this values IS serialized, and this value will be got from the above static
	 */
	LocalDateTime timeId;//serialized
	/*
	 * each school will have a number of teachers, can't have same teacher in this set twice
	 */
	Set<Teacher>teacherSet=new HashSet<>();//serialized
	/*
	 * each school will have a number of pupils
	 * no duplicates so it's also a set
	 */
	Set<Pupil>pupilSet=new HashSet<>();//will be serialized
	int teacherCount;//serialized
	int pupilCount;//serialized
	/*
	 * this will NOT be serialized as it does NOT implement Serializeable, so we have to mark this as
	 * TRANSIENT, if we did NOT mark this as transient we would get NotSerializableException
	 */
	transient Janitor myJanitor=new Janitor();
	/*
	 * you can mark any instance variable as transient, even a object that does implement serializable
	 * i.e here we have the Headmaster, which is a teacher, which does implement serializable but we have 
	 * choosen to mark it as transisent and will be ignored by serialization process
	 */
	transient Teacher headMaster;
	
	School(){
		name="St Joan's";
		//increments by one to keep a count of how many schools created which will be used to give
		//the school a unique id
		counter++;
		//three new teachers added to each school
		teacherSet.addAll(Arrays.asList(new Teacher(),new Teacher(),new Teacher()));
		//four new pupils for each school
		pupilSet.addAll(Arrays.asList(new Pupil(),new Pupil(),new Pupil(),new Pupil()));
		//counter will NOT be serialized, but schoolId WILL BE serialized
		schoolId=counter;
		start=LocalTime.of(9, 0);//starts at 9 o'clock every morning
		//this will be give a unique name to our serialized file
		//rightNow is the current time
		timeId=rightNow;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", start=" + start + ", schoolId=" + schoolId + ", teacherSet=" + teacherSet
				+ ", pupilSet=" + pupilSet + "]";
	}
	
	
	
	
	
	
	

}
