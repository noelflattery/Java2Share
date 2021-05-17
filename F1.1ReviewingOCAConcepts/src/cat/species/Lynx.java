package cat.species;

import cat.BigCat;
/**
 * This is a concrete sub class of a concrete super class {@link cat.BigCat} and will only have access to the public and protected 
 * variables of this class which are the public variable {@link cat.BigCat#name} and the protected variable {@link cat.BigCat#hasFur}. As this
 * class is in a different package to BigCat, it will not be able to access the package level variables
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/YKdqpdTqtyw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see cat.BigCat
 * @author NoelF
 *
 */
public class Lynx extends BigCat{
	/**
	 * method to demonstrate what we can and cannot access in the super class BigCat, which is in a different package to this class.
	 * we are only able to access the public variable {@link cat.BigCat#name} and the protected variable {@link cat.BigCat#hasFur}. we cannot
	 * access private or package level members as Lynx is in a different package to BigCat class
	 * @see cat.BigCat
	 * @see cat.BigCat#name
	 * @see cat.BigCat#hasFur
	 */
	void access() {
		/*
		 * can access public members of the BigCat class
		 */
		System.out.println("name is "+name);
		/*
		 * can access protected members
		 */
		System.out.println("hasFur is "+hasFur);
		/*
		 * cannot access package level access members in a different
		 * package
		 */
	//	System.out.println(hasPaws);
		/*
		 * id is a private variable, cannot access private members
		 * outside of this class
		 */
		//System.out.println(id);
		
		
		
		
	}
}
