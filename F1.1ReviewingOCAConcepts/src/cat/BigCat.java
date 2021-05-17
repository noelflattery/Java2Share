package cat;
/**
 * public class means it is available to all other classes and can create a BigCat Object in all other classes. This class is the 
 * super class of {@link cat.species.Lynx}
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/YKdqpdTqtyw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class BigCat {
	/**name of BigCat and is public so available to all other classes*/
	public String name="tibbles";
	/**boolean variable true if the cat has fur, false if have no fur. Protected variables to available to classes in same package, which
	 * are {@link cat.Cat} and {@link cat.CatAdmirer} and to any classes that inherit from this class. Only one class is a sub class of 
	 * BigCat and that is {@link cat.species.Lynx}
	 * @see cat.species.Lynx
	 */
	protected boolean hasFur=true;
	/**boolean variable true if the cat has paws, false if have no paws. package level variable availe to classes in same package, which are
	 * are {@link cat.Cat} and {@link cat.CatAdmirer} 
	 */
	boolean hasPaws=true;
	/**id of the cat and this is a private variable which means this variable can only be accessed inside the BigCat class*/
	private int id;

}
