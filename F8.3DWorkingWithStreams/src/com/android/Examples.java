package com.android;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;

import com.android.Human.Job;

public class Examples {
	
	static Set<File>files=new HashSet<>();
	static void ex1() {
		/*
		 * we have overriden the equals and hashCode method of the Human file
		 */
		Human myHuman=new Human(34,"andy",78.86,Job.DOCTOR);
		Human myHuman2=new Human(48,"helen",56.78,Job.DOCTOR);
		Human myHuman3=new Human(22,"sean",67.89,Job.NURSE);
		Human myHuman4=new Human(56,"siobhan",51.22,Job.TEACHER);
	//	serializeHuman(myHuman);//andy, each time we run this command we create a new Serialized file
	//	serializeHuman(myHuman2);//helen
	//	serializeHuman(myHuman3);//sean
	//	serializeHuman(myHuman4);//siobhan
		//we are using the hashCode of the Human class to uniquely identify each human and each file
		System.out.println(myHuman.hashCode());
		int check=myHuman.hashCode();
		/*
		 * if this is the correct number for this verion of Andy, the file will create a deserialized 
		 * object
		 * check is the correct hashcode for this file
		 */
		Human newHuman=deSerializeHuman("andy359000000.data",check);
		System.out.println(newHuman);
		newHuman=deSerializeHuman("andy359000000.data",12);
		System.out.println(newHuman);
		/*
		 * myHuman is andy
		 */
		myHuman.age=78;
		check=myHuman.hashCode();
		newHuman=deSerializeHuman("andy359000000.data",check);
		System.out.println(newHuman);
	//	System.out.println(newHuman.hashCode());
	//	System.out.println(myHuman);
	//	System.out.println(myHuman.equals(newHuman));
		
		
		
	}
	static Human deSerializeHuman(String fileName,int check) {
		/*
		 * this will be the human created when we deserialize our file
		 */
		Human myHuman;
		try(FileInputStream fileIn=new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fileIn);){
				myHuman=(Human)in.readObject();
				/*
				 * if the number sent to this method, is the hashcode of the Human object we
				 * wish to deserialize, then return that human
				 * otherwise, null be returned
				 */
				if(check==myHuman.hashCode())
					return myHuman;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	//a method to serialize a Human object
	static void serializeHuman(Human myHuman) {
		long nanoSeconds=LocalTime.now().getNano();
	//	System.out.println("nanoseconds is "+nanoSeconds);
		//the serialized file will be made up of the Humans name plus the nanoseconds in the current second
		String fileName=myHuman.name+nanoSeconds+".data";
		files.add(new File(fileName));
		System.out.println(fileName);
		try(
				FileOutputStream fileOut=new FileOutputStream(fileName);//for bytes
				ObjectOutputStream out=new ObjectOutputStream(fileOut);
				){
					out.writeObject(myHuman);	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
