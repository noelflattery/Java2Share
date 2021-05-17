package com.android;
	/**
	 * Cards class that has a 
	 * overridden hashcode and equals method
	 * this does NOT override the toString method
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 * @author NoelF
	 */
public class Cards {
/**
 * fields of Cards class 
 */	
	final String name=null;
	/** rank of cards i.e ace, queen, king, one, two,etc*/
	private String rank;
	/** suit of cards i.e diamonds, club, etc*/
	private String suit;
	/**constructor that takes no arguements*/
	Cards(){
		
	}
	/**Constructor that takes a String rank and a String suit
	 * includes a check to make sure the rank and suit variables are not null
	 * @param rank rank of card
	 * @param suit suit of card
	 */
	public Cards(String rank,String suit) {
		/*with a constructor, without this check you could  create a
		 * cards object by the following 
		 * Cards newCards=new Cards(null,null)
		 * we could use this method
		 * this forces the programmer to give a value to both rank
		 * and suit
		 * or we could put a check in the equals method to ensure if
		 * one of the strings are null, it will always return false
		 */
		if(rank==null||suit==null)
			throw new IllegalArgumentException();
		this.rank=rank;
		this.suit=suit;
	}
	/**
	 * overriden hashcode method that uses all the variables of the card class
	 * @return a number that is created from the cards Suit and rank
	 */
	@Override
	public int hashCode() {
		/*
		 * 31 is prime number, meaning it is only divisible by itself or
		 * one. Also this number is final, so it cannot be changed
		 */
		final int prime = 31;
		int result = 1;
		/*
		 * result =31*1+(if rank is null thend 0, else rank.hashcode which
		 * calls the String implementation of the hashcode method
		 * so for example we will say 31*1+20=51
		 */
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		//31*51+50
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	/**
	 * uses all variables to create a overridden equals method
	 * @param obj the object that the Cards object callin this method is comparing itself too.
	 * @return returns true if have the same suit and rank, false in all other circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cards))
			return false;
		Cards other = (Cards) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}
	
	
	
	

}
