package com.android;

import java.util.Arrays;
import java.util.List;
/**
 * an class that cotains an inner enum for 7 planets
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class SolarSystem {
	/**
	 * creates an array of 6 planets from our inner enum
	 */
	private Planets[]planetArray=new Planets[6];
	/**constructor that creates our SolarSystem using 6 Planet enum types*/
	SolarSystem() {
		/*
		 * its at this line that all our planet enum types are create
		 * the constructors are only called at this line
		 */
		planetArray[0]=Planets.EARTH;//uses toString from enum body
		planetArray[1]=Planets.MARS;//uses toString from enum body
		planetArray[2]=Planets.VENUS;//uses toString from enum body
		planetArray[3]=Planets.MERCURY;//uses toString from enum body
		planetArray[4]=Planets.JUPITER;//uses it's OWN toString
		planetArray[5]=Planets.SATURN;//uses toString from enum body
	}
	/**
	 * toString method of the the Solarsystem class that will print all of the details of each planet
	 * the Planet enum has it's own toString method which will be called by the list interfaces toString
	 * metho
	 */
	@Override
	public String toString() {
		List<Planets>listPlanets=Arrays.asList(planetArray);
		return listPlanets.toString();
	}
	/**
	 * this enum type is ONLY available inside the solarsytem class, you will not
	 * be able to create a Planet outside of this class, this enum
	 * also implements the Cosmic interface, which has two method
	 * void gravity()
	 * and void move()
	 */
	private enum Planets implements Cosmic{
		/**use no arguement constructor*/
		EARTH
		/**use no arguement constructor*/
		,MARS,
		/**use no arguement constructor*/
		VENUS,
		/**use no arguement constructor*/
		MERCURY,
		/**use constructor that takes an int, double and double and uses anonymous class implementation*/
		JUPITER(45_000_000,56789.89,98_765.99){
			/**
			 * these were methods in the Cosmic interface, which we 
			 * did override in the main enum body. however we choose
			 * to override them again here, so that means juipter will 
			 * have its own gravity and move() method
			 */
			@Override
			public void gravity() {
				System.out.println("Jupiters own gravity method");
			}
			/**Jupiters overriding move method*/
			@Override
			public void move() {
				System.out.println("Jupiters own move method");
			}
			/**Jupiters override method
			 * here we choose also to override the toString() method,
			 * so jupiter is the only planet that has it's own
			 * unique toString method
			 */
			@Override
			public String toString() {
				String str="largest planet is "+name()+" population is "+
			population+" surfaceArea is "+surfaceArea+"size is "+size;
				return str;
			}
		},
		/**use constructor that takes an int, double and double and provides no implemeantion for any method*/
		SATURN(35_000_000,12343.56,2_345.67);
		/**population of the planet*/
		int population;
		/**surface area of the planet*/
		double surfaceArea;
		/**size of the planet*/
		double size;
		/**
		 * this is the constructor that will be called when a planet enum
		 * is created that takes not arguments, which will be 
		 * EARTH,MARS,VENUS and MERCURY
		 */
		private Planets() {
			/*
			 * this will assign a population, a surfaceARea and a size
			 * based on the ordinal of the enum
			 */
			population=(ordinal()+1)*4;
			surfaceArea+=(ordinal()+1)*7;
			size+=(ordinal()+1)*2;
			/*
			 * this calls the toString() method for this planet
			 * for all planets, except Juipiter, this will call the 
			 * toString() method in the main enum body
			 */
			System.out.println(this);
			/*
			 * calls the gravity and move() method for this planet
			 */
			gravity();
			move();
			
		}
		/**
		 * this is a constructor that takes a int population, a double surfaceArea and a double size
		 * and will be called when creating JUPITER and SATURN
		 */
		private Planets(int population,double surfaceArea,double size) {
			this.population=population;
			this.surfaceArea=surfaceArea;
			this.size=size;
			
			System.out.println(this);
			gravity();
			move();
		}
		/**
		 * EARTH, MARS,VENUS,MERCURY and SATURN will call this version of
		 * this methods
		 */
		@Override
		public void gravity() {
			System.out.println(name()+"general gravity method for planets");
			
		}
		/**
		 * EARTH, MARS,VENUS,MERCURY and SATURN will call this version of
		 * this methods
		 */
		@Override
		public void move() {
			System.out.println(name()+" general move method for planets");
			
		}
		/**
		 * EARTH, MARS,VENUS,MERCURY and SATURN will call this version of
		 * this methods
		 */
		@Override
		public String toString() {
			String str="name of planet "+name()+" population "+population+
					" surfaceArea "+surfaceArea+" size"+size;
			return str;
		}
		
	}

}
/**interface implemented by the inner enum type Planets
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
interface Cosmic{
	/**abstract method that will be overridden by the enum class Planets*/
	void gravity();
	/**abstract method that will be overridden by the enum class Planets*/
	void move();
}
