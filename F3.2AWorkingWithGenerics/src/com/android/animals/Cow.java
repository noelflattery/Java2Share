package com.android.animals;
/**Cow class subclass of Animal, uses an inner static class to create a Cow
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>*/
public class Cow extends Animal{
	/**age of Cow only available to Cow or a subclass of Cow*/
	private int age;
	/**Cow constructor that takes no arguements
	 * can't create a Cow outside of the Cow class, will use the builder pattern to create a cow*/
	private Cow() {
		System.out.println("Cow created");
	}
	/**nested inner static class CowBuilder with setters for each variable of the Cow class*/
	public static class CowBuilder{
		/**creates an instance of Cow using the private constructor of the outer Cow class, which this can do
		 * as this is an inner class of the Cow class
		 */
		private Cow myCow=new Cow();
		/**setter for height, returns a CowBuilder object*/
		public CowBuilder setHeight(double height) {
			myCow.height=height;
			return this;
		}
		/**Setter for Weight, returns a Cowbuilder object*/
		public CowBuilder setWeight(double weight) {
			myCow.weight=weight;
			return this;
		}
		/**Setter for age, returns a CowBuilder object*/
		public  CowBuilder setAge(int age) {
			myCow.age=age;
			return this;
		}
		/**build() method that returns the cow that has been given values by the setters*/
		public Cow build() {
			return myCow;
		}
	}
	

}
