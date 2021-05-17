package com.android;
/**
 * File contains Primate, Howler extends Primate, class Tail, class Horse, class Shetland extends Horse
 * class Feather, class Bird
 * Primate class is the super class of Howler
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoeFl
 *
 */
public class Primate {

}
/**
	 * only howlers and subclasses of Howlers will have a tail, so Howlers and 
	 * sub classes of Howlers will have a HAS-A relationship with the myTail
	 * Attribute
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
class Howler extends Primate
{
	/**a check to if this Howler has an existing tail, if false a new one will be created*/
	boolean hasTail;
	/**the tail object every howler should have*/
	private Tail myTail;
	/**constructor for the Howler class, which takes a boolean, if true, no new tail needs to be created
	 * if false a new tail will be created and assigned to myTail atribute
	 * @param hasTail
	 */
	Howler(boolean hasTail){
		if(hasTail)
			myTail=new Tail();
	}
}
/**Tail is the object that every Howler Monkey will have, so  Howler HAS-A tail
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Tail{
	
}
/**
 * the myTail atribute of the Horse class is a HAS-A relationship as all
 * horses and subclasses of Horse will have a tail
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Horse{
	/**the tail atribute for each horse*/
	private Tail myTail;
	/**constructor that takes no arguements and assigns a new tail to the mytail atribute*/
	Horse(){
		myTail=new Tail();
	}
	/**a method to check if the horse has a Tail, can be used to enforce and make sure a Horse will
	 * have a Tail
	 */
	void checkTail() {
		System.out.println();
		if(myTail==null)
			System.out.println("no tail");
		else
			System.out.println("has a tail");
	}
}
/**Shetland is a subclass of Horse and all sub classes of Horse also HAS-A relationship with the Tail class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Shetland extends Horse{
	
}
/**
 * every bird has feathers, so every bird will have an array of feathers, so Bird HAS-A relationship with
 * Feather
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Feather{
	
}
/**
 * a bird HAS feathers, in this case an array of thousands of feathers, again this
 * is a HAS-A relationship
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Bird{
	/**this is our array of feathers, which holds all the feathers of the bird*/
	private Feather[]feathers;
	
	/**Bird class constructor that takes no arguements and creates an array of feathers of random
	 * amounts up to 100,000 feathers 
	 */
	Bird(){
		//this sets the amount of feathers, its between 1 and 100,000
		int numFeathers=(int)Math.random()*100_000;
		System.out.println("this bird has "+numFeathers+" feathers");
		//this creates an array of the amount of feathers we have got from
		//the above calculation (a number between 0 and 100,000 feathers
		feathers=new Feather[numFeathers];
	}
	
}
