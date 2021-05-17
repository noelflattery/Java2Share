package cat;
/**
 * Abstract class Cat means you can't create an instance of this class, you can have an abstract reference to concrete subclass of Cat, such as
 * {@link cat.Lion}. An abstract method can only exist inside a abstract class, and we have one in this class {@link cat.Cat#clean()} and 
 * any class the inherits from this class has to implement this method.
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/YKdqpdTqtyw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *@see cat.Lion
 */
public abstract class Cat {
	/**
	 * we want the lion to clean itself, so we have 3 options for
	 * this.
	 * Option 1 not have a clean method in the abstract Cat class
	 * and have an independant clean method in the Lion class
	 * Option 2
	 * have an abstract method clean in the Cat class, which
	 * would mean we would HAVE to have a clean() method in the Lion
	 * Option 3
	 * have a concrete method in the Cat class 
	 * i.e
	 * void clean(){
	 * 		System.out.println("I am a Cat cleaning myself");
	 * we choose option 2
	 * }
	 */
	abstract void clean();

/*	void clean() {
		System.out.println("I am a member of the cat family cleaning");
	}*/
}
/**
 * this class is a subclass of abstract class {@link cat.Cat} and has to provide a body for the abstract method {@link cat.Cat#clean()}
 * As any class that is a sub class of a abstract super class has to override the abstract methods of the super class
 *@see cat.Cat
 * @author NoelF
 */
class Lion extends Cat{
/**
 * this is the overriding the abstract method {@link cat.Cat#clean()} of the abstract class {@link cat.Cat} and you have to override a 
 * abstract method of the super class in a concrete sub class
 */
	@Override
	void clean() {
		// TODO Auto-generated method stub
		
	}
	/*	void clean() {
			System.out.println("I am a clean lion");
		}*/
}
