package com.android.animals;
/**
 * Cow class that uses a inner static CowBuilder class to create A cow 
 * @author Owner
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Cow extends Animal{
	/**age of Cow*/
	private int age;
	/**can't create a Cow outside of the Cow class, will use the builder pattern to create a cow*/
	private Cow() {
		System.out.println("Cow created");
	}
	/**nested inner static class used to create and give values to Cow objects*/
	public static class CowBuilder{
		/**Cow object that will have it's different atributes assigned values by the various setters*/
		private Cow myCow=new Cow();
		/**setter for height*/
		public CowBuilder setHeight(double height) {
			myCow.height=height;
			return this;
		}
		/**setter for weight*/
		public CowBuilder setWeight(double weight) {
			myCow.weight=weight;
			return this;
		}
		/**setter for age*/
		public  CowBuilder setAge(int age) {
			myCow.age=age;
			return this;
		}
		/**build() method that returns the Cow object that will have been given values to the atribute of a cow*/
		public Cow build() {
			return myCow;
		}
	}
	

}
