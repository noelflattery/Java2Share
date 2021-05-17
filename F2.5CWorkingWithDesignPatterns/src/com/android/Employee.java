package com.android;

import java.time.LocalDate;
/**
 * this is an immutable class Employee and using an nested inner static class EmployeeBuilder to create
 * Employee's with setters for each variable and a builder to return this object
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public final class Employee {
	/**toString method of Employee that prints out all details of Employee*/
	@Override
	public String toString() {
		return "Employee [name=" + name + ", startDate=" + startDate + ", role=" + role + ", wages=" + wages
				+ ", gender=" + gender + "]";
	}
	/**
	 * with an IMMUTABLE (cannot change) class each time we add a new variable, we have to 
	 * add this to our constructor and also add a getter for this to our Builder class
	 * and also make sure we are calling the right constructor in the Builder class
	 */
	private final String name;
	/**immutable date the Employee started work*/
	private final LocalDate startDate;
	/**
	 * this enum is not private as i want to access this outside of the Employee, but you
	 * could make it private and would be accessible in the inner static class
	 */
	enum Title{
		MANAGER,SUPERVISOR,GENERAL
	}
	/**role of employee*/
	private final Title role;
	/**wages of Employee*/
	private final double wages;
	/**false for male, true for male*/
	private final boolean gender;
	/**will show how many Employees are created*/
	static int empCount=0;
//	private final Human boss;
//	private final Animal pet;
	/**constructor for Employee that takes a name, startDate, Title, wages and gender
	 * any new variables HAS TO be added in here
	 * @param name
	 * @param startDate
	 * @param role
	 * @param wages
	 * @param gender
	 */
	private Employee(String name, LocalDate startDate, Title role, double wages, boolean gender) {
		super();
		//keeps a count of the amount of employees called
		empCount++;
		System.out.println("Employee "+empCount+" created");
		this.name = name;
		this.startDate = startDate;
		this.role = role;
		this.wages = wages;
		this.gender = gender;
	}
	/**nested static builder class used to create Employee objects*/
	static class EmployeeBuilder{
		/**
		 * have to have the same variables types as the Employee class, as these are NOT final
		 * this will allow our Employee, which is Final, to have default values
		 */
		private String name;//default null
		/**startDate for Employee, used in setter*/
		private LocalDate startDate;//default null
		/**title of the role, used in setter*/
		private Title role;//default null
		/**wages of employee, used in setter*/
		private double wages;//default 0.0
		/**gender of employee, used in setter*/
		private boolean gender;//default false
		/**setter for name, returns Employeebuilder*/
		public EmployeeBuilder setName(String name) {
			this.name=name;
			return this;
		}
		/**setter for startDate*/
		public EmployeeBuilder setStartDate(LocalDate startDate) {
			
			this.startDate=startDate;
			return this;
		}
		/**setter for role*/
		public EmployeeBuilder setRole(Title role) {
			this.role=role;
			return this;
		}
		/**setter for wages*/
		public EmployeeBuilder setWages(double wages) {
			this.wages=wages;
			return this;
		}
		/**setter for gender*/
		public EmployeeBuilder setGender(boolean gender) {
			this.gender=gender;
			return this;
		}
		/*
		 * any new variables, put setter for here
		 */
		/**build method for Employee the returns a New Employee with all the variables from the setters*/
		public Employee build() {
			/*
			 * this is using hte private constructor in the Employee class that takes a
			 * String,LocalDate,Role enum, double, boolean
			 */
			return new Employee(name, startDate, role, wages, gender);
		}
	}
	

}
