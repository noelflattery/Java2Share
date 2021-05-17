package com.android;

public class Examples {
	
	static void ex1() {
		System.out.println("use equals when determining if a string is equql");
		String s1="bunny";
		String s2="bunny";
		String s3=new String("bunny");
		System.out.println(s1==s2);//true
		System.out.println(s2==s3);//false
		System.out.println(s2.equals(s3));//true
		//everythign after a string is a string
		String s4="1"+2+3;//this is the string 123
		/*
		 * 1+2 are ints so this is adding the two numers, which becomes 3
		 * then we concatenate 3 with the String "3", which becomes the string "33"
		 */
		String s5=1+2+"3";//before a string, considered a number
		
	}
	static void ex2() {
		System.out.println("String methods");
		String s="abcde";
		System.out.println(s.trim().length());//5
		System.out.println(s.charAt(4));//e, uses array numbering
		System.out.println(s.indexOf('e'));//4
		System.out.println(s.indexOf("de"));//3
		System.out.println(s.substring(2,4));//cd
		System.out.println(s.replace('a', '1'));//1bcde
		System.out.println(s.contains("DE"));//false
		System.out.println(s.startsWith("a"));//true
		/*
		 * Strings are immutable so all methods of the string class do not change the string
		 */
		System.out.println(s);//string is still abcde
		
	}
	
	static void ex3() {
		System.out.println("StringBuilder ");//a mutable string
		StringBuilder b=new StringBuilder();
		/*
		 * methods of the stringbuilder class do change the stringbuilder object
		 */
		b.append(12345).append('-');
		System.out.println(b);
		System.out.println(b.length());//6
		System.out.println(b.indexOf("-"));//5
		System.out.println(b.charAt(2));//3
		/*
		 * this method changes the stringBuilder object
		 */
		System.out.println(b.reverse());;
		System.out.println(b);//-54321
		StringBuilder sb=new StringBuilder("abcde");
		sb.insert(1, '*').delete(3, 4);//inserts * at position 1, and deletes from position 3 upto 4, but not including 4
		System.out.println(sb);//end up with a*bde
		System.out.println(sb.substring(1,4));//*bd
		System.out.println(sb);//substring does NOT change the stringBuilder
	}

}
