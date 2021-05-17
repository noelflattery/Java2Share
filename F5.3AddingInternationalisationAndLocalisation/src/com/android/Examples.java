package com.android;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import com.bundle.Animal;
import com.bundle.Animal.Type;

public class Examples {
	static void ex1(){
		System.out.println("locales");
		/*
		 * all localisation is based on Locales, which is basically the areas of the world you can reside, usually
		 * corresponds to a country, but not alway
		 */
		Locale myLocale=Locale.getDefault();
		System.out.println(myLocale);
		/*
		 * My machine is using english and is residing in Ireland
		 * so will print out en_IE
		 * language first, always in lowercase, has to be an underscore next and then followed by the short hand
		 * for the country
		 * Underscore and country code are optional
		 */
		System.out.println(Locale.GERMAN);//this is just the language
		System.out.println(Locale.GERMANY);//this is german_germany, which will look like de_DE
		
		Locale frenchie=new Locale("fr");
		System.out.println(frenchie);//just the language
		//this is a locale of the language of hindi and the country of india
		System.out.println(new Locale("hi","IN"));
		/*
		 * this will compile and it's not that this is invalid, its that if you use non standard locales you
		 * can get non standard results
		 */
		System.out.println(new Locale("fr","IE"));//french language in Ireland
		/*
		 * you can also use the builder pattern to create locales (Locale has a builder method)
		 * whereas you can use lowercase for country, it's not recommended it's convention to use uppercase
		 * for countries
		 */
		Locale l1=new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2=new Locale.Builder().setRegion("UK").setLanguage("en").build();
		System.out.println("our locales");
		System.out.println(l1);
		System.out.println(l1.getCountry());
		System.out.println(l2.getLanguage());
		System.out.println("getAvailableLocales()");
		/*
		 * this returns an array of all the available locales on this machine
		 */
		Locale[]locales=Locale.getAvailableLocales();
		List<Locale>locList=Arrays.asList(locales);
		System.out.println(locList.stream().count());
		
		//this is a list of all the Locales
		/*
		 * gets all the languages spoken in Ireland
		 */
		System.out.println(locList);
		locList.stream().
		filter(l->l.getCountry().equals("IE")).
		forEach(System.out::println);
		/*
		 * gets all the locales where english is spoken
		 */
		System.out.println("Locales where english is spoken");
		System.out.println(locList.stream().
				filter(l->l.getLanguage().equals("en")).
				peek(System.out::println).
				count());
		System.out.println("creating a list of the languages");
		List<String>languages=locList.stream().//creates a stream of locales
				map(l->l.getLanguage()).//converts our Locale to a string, which will be the language
				filter(s->s.length()>0).//only allow strings that are not blank
				collect(Collectors.toList());//saves them to a list
		System.out.println("creating a list of the countries");
		List<String>countries=locList.stream().
				map(l->l.getCountry()).
				filter(s->s.length()>0).//there are a number blank countries, so this filters out the blanks
				collect(Collectors.toList());
		System.out.println("our list of countires is "+countries);
		System.out.println("our list of languages is "+languages);
		System.out.println("unique counties");
		System.out.println("amount of countries "+countries.size());
		System.out.println("amount of distinct countries "+countries.parallelStream().distinct().count());
		System.out.println("unique languages ");
		System.out.println("amount of languages "+languages.size());
		System.out.println("amount of distinct language "+languages.stream().distinct().count());
		
		/*
		 * you can change the default locale by the following method, but in practise your
		 * don't this much, but in the exam this does happen a fair bit
		 * DO NOT RUN THIS CODE AS THIS CAN HAVE UNFORSEEN CIRCUMSTANCES
		 * System.out.println(Locale.getDefault()); // en_IE
			Locale locale = new Locale("fr");
			Locale.setDefault(locale); // change the default
			System.out.println(Locale.getDefault()); // fr
		 */		
	}
	
	static void ex2() {
		System.out.println("using a Resource bundle");
		/*
		 * resource bundles can a java class OR a properties file
		 */
		Locale us=new Locale("en","US");
		Locale germany=new Locale("de","DE");
		/*
		 * to create a properties file in eclipse, click on new 
		 * file, then go to the correct package and save the file by naming it
		 * MyBundle.properites, YOU have to include the file extension
		 * then you create a resourceBundle, from the full file name (package plus file name, but not
		 * file extension)
		 * and use this resource bundle to access each of the values through they're keys
		 * this can access only ONE properties file, usually with a resource bundle you can access number
		 * of files
		 */
		ResourceBundle rb=ResourceBundle.getBundle("com.android.MyBundle");//just getting the MyBundle properties file
		System.out.println("first statement ");
		//key for this is hello, value is hello
		System.out.println(rb.getString("hello"));
		System.out.println("second statement ");
		//key for this is open, value is The zoo is open.
		System.out.println(rb.getString("open"));
		System.out.println("displays all keys");
		System.out.println(rb.keySet());//this produces a set of STrings whihc are the keys
		System.out.println("display all values");
		rb.keySet().stream().
		map(k->rb.getString(k)).
		forEach(System.out::println);
		System.out.println("also display all values");
		rb.keySet().stream().forEach((k)->{
			System.out.println("key is "+k);
			System.out.println("value is "+rb.getString(k));
		});
		
		System.out.println("creating a resource bundle with multiple property files");
		
		Locale france=new Locale("fr","FR");
		/*
		 * this is bundle that is based on all files in the com.bundle package that begin with the word
		 * Zoo, after the underscore in the properites name file, denotes what language we are dealing with
		 * in this example, we create a bundle of the files in the com.bundle package, that begin with the 
		 * word "zoo", and then we supply a locale, which will search the bundle for a file that uses that
		 * language
		 * "com.bundle.Zoo",france
		 * will use the file in com.bundle Zoo_fr.properties
		 */
		ResourceBundle rbMult=ResourceBundle.getBundle("com.bundle.Zoo",france);
		System.out.println(rbMult.keySet());
		System.out.println("in french");
		System.out.println("zoo hello "+rbMult.getString("hello"));
		System.out.println("zoo open "+rbMult.getString("open"));
		
		System.out.println("in german");
		rbMult=ResourceBundle.getBundle("com.bundle.Zoo",germany);
		System.out.println("zoo hello "+rbMult.getString("hello"));
		System.out.println("zoo open "+rbMult.getString("open"));
		
		System.out.println("non existant key");
		/*
		 * if you attempt to access a non existent key, you will get a MissingResourceException, which is a
		 * RunTimeException
		 */
	//	System.out.println(rbMult.getString("muck"));
		System.out.println("in english");
		rbMult=ResourceBundle.getBundle("com.bundle.Zoo",us);
		System.out.println("zoo hello "+rbMult.getString("hello"));
		System.out.println("zoo open "+rbMult.getString("open"));
		
	//	getLocalDetails(rbMult);
		ResourceBundle rbUs=ResourceBundle.getBundle("com.bundle.Zoo",us);
		System.out.println("keys of US locale are ");
		Set<String>keys=rbMult.keySet();
		System.out.println(keys);
		System.out.println("values of a US locale are");
		Set<String>values=keys.stream().
				map(k->rbUs.getString(k)).
				collect(Collectors.toSet());
		System.out.println(values);
		/*
		 * if you don't provide a locale, it will take the default locale, HOWEVER you HAVE TO
		 * HAVE A FILE FOR IT TO WORK.
		 * if you did NOT have a _en file in this bundle, this will not compile
		 * there has to be a Zoo_en file inside the com.bundle package
		 */
		ResourceBundle rb4=ResourceBundle.getBundle("com.bundle.Zoo"/*,new Locale("EN")*/);
		System.out.println("****");
		System.out.println(rb4.keySet());
		rb4.keySet().stream().forEach(k->{
			System.out.println("key is "+k);
			System.out.println("value is "+rb4.getString(k));
		});
		
		
	}
	//this gets all the keys and values of a particular properties file
	static void getLocalDetails(ResourceBundle myRb) {
		System.out.println(myRb.keySet());//all the keys
		myRb.keySet().stream().forEach((k)->System.out.println(myRb.getString(k)));//all teh values
	}
	
	static void ex3() {
		System.out.println("properties class");
		/*
		 * a Properties class is a java in built class which stores the values and keys of a 
		 * properties file
		 */
		Properties props=new Properties();
		Locale germany=new Locale("de","DE");
		ResourceBundle rb=ResourceBundle.getBundle("com.bundle.Zoo",germany);
		rb.keySet().stream().forEach(k->props.put(k, rb.getString(k)));
		/*
		 * this will print out
		 * {open=Der Zoo ist geoffnet, key=	 tabbed key	 some more text 
 new line backslash, hello=Hallo, fish=Hai, animal=Das ist ein Delphin}
		 */
		System.out.println(props);
		System.out.println(props.keySet());//this will get all the keys
		System.out.println(props.get("open"));//this will get the value for this key
		System.out.println("getting all the values of a properties file");
		props.keySet().stream().map(k->props.get(k)).forEach(System.out::println);
	//	keys.stream().map(k->rb2.getString(k)).collect(Collectors.toSet());
		System.out.println("props contains all keys and values of the Germany Locale");
		/*
		 * second values
		 */
		
		System.out.println(props.elements().nextElement());//first value in germany locale
		System.out.println(props.keys().nextElement());//first key in germany locale
		
	}
	
	static void ex4() {
		System.out.println("java class resource bundle");
		Locale ireland=new Locale("en","IE");
		Locale germany=new Locale("de","DE");
		Locale france=new Locale("fr","FR");
		/*
		 * this can contain both classes and property files, not necessarily a good idea.
		 * this bundle is made up of all the classes in the com.bundle package and begin with
		 * the word "Farm" before the underscore
		 */
		System.out.println("Irish farm");
		ResourceBundle rb=ResourceBundle.getBundle("com.bundle.Farm",ireland);
		System.out.println(rb.getString("open"));//the farm is now open for business
		System.out.println(rb.getString("hello"));//hello and welcome to our farm
		System.out.println("German farm");
		 rb=ResourceBundle.getBundle("com.bundle.Farm",germany);
		 //Die Farm ist jetzt für Business geöffnet
		 System.out.println(rb.getString("open"));
		 //hallo und willkommen auf unserem bauernhof
		 System.out.println(rb.getString("hello"));
		 System.out.println("French farm");
		 rb=ResourceBundle.getBundle("com.bundle.Farm",france);
		 /*
		  * The values for open are a Object of Type Animal, we also have an two dimensional array
		  * of type object, so we can't use "getString", so you have to use "getObject"
		  * values can be any type you want with a class that controls your locale properties
		  */
		 System.out.println(rb.getObject("hello"));
		 System.out.println(rb.getObject("open"));//this has a Animal object value
		 System.out.println(rb.getObject("close"));//this has a ArrayList of Integers value
		 System.out.println(rb.keySet());
		 /*
		  * if you don't define a locale for your ResourceBundle, it will be take the default
		  * bundle of  your machine, which is "en", "IE", Which is English Ireland
		  */
		 rb=ResourceBundle.getBundle("com.bundle.Farm");
		 System.out.println(rb.getString("hello"));
		 System.out.println(rb.getString("open"));
		 
		 /*
		  * creating a bundle for offices
		  */
		 System.out.println("office in france");
		 rb=ResourceBundle.getBundle("com.android.Office",france);
		 System.out.println(rb.getString("hello"));
		 System.out.println(rb.getString("open"));
		 /*
		  * this uses the default locale, which is the locale of this machine, which is 
		  * the english language. howvever there is NO ENGLISH locale in this bundle, only 
		  * french, so if you attempt to use any other locale, other than english, you will 
		  * get a MissingResourceException
		  */
		// rb=ResourceBundle.getBundle("com.android.Office");
		 /*
		  * there is not de locale for this this bundle, so this will also returns a 
		  * MissingResourceException
		  */
		// rb=ResourceBundle.getBundle("com.android.Office",germany);
		 
		 rb=ResourceBundle.getBundle("com.android.Zoo",ireland);//work as en locale exists in bundle
		 System.out.println(rb.getObject("open"));
		 rb=ResourceBundle.getBundle("com.android.Zoo",germany);//workds as de locale exists in bundle
		 System.out.println(rb.getObject("open"));
		 /*
		  * if it cannot use the locale (here the Zoo_fr file is NOT A PUBLIC class, it is 
		  * a package level class inside the Zoo_fr file) java will attempt to use the 
		  * default locale instead, which is english on this machine.
		  * if you are using resourceBundle, that means you have to have a public class
		  * ending with the words "en", here we have a file called Zoo_en
		  */
		 rb=ResourceBundle.getBundle("com.android.Zoo",france);
		 System.out.println(rb.getObject("open"));
			 
	}
	
	static void ex5() {
		Locale us=new Locale("en","US");
		Locale irish=new Locale("en","IE");
		System.out.println("Tax in the United states");
		/*
		 * this is using the language, which is english (en) and the country, which is the US
		 * (US)
		 * This is using the Tax_en_US public class
		 */
		ResourceBundle rb=ResourceBundle.getBundle("com.money.Tax",us);
		System.out.println(rb.getObject("tax"));
		System.out.println("tax in Irelnad");
		/*
		 * this is using the language, which is english and the countery, which is IRELAND (IE)
		 * this is using the Tax_en_IE
		 */
		rb=ResourceBundle.getBundle("com.money.Tax",irish);
		System.out.println(rb.getObject("tax"));
		/*
		 * if you don't provide a locale, it will use the default locale which is 
		 * english and Ireland
		 */
		rb=ResourceBundle.getBundle("com.money.Tax");
		System.out.println(rb.getObject("tax"));
			
	}
	
	static void ex6() {
		//this uses the english ireland locale, as thats the default locale
		//if you don't provide a locale it will always take the default locale
		/*
		 * this resource bundle has a choice in that it can use eitehr
		 * House_en.properties file 
		 * or House_en.java file
		 * it's first preference will be teh House_en.properties file
		 */
		ResourceBundle rb=ResourceBundle.getBundle("com.android.house");
		rb.keySet().
		stream().
		map(k->"key is "+k+" value is "+rb.getString(k)).
		forEach(System.out::println);
		
//		Locale.setDefault(new Locale("hi"));
		//	ResourceBundle rb5 = ResourceBundle.getBundle("Zoo", new Locale("en"));
		
	}
	
	static void ex7() {
		Locale locale=new Locale("en","CA");//english canada
		ResourceBundle rb=ResourceBundle.getBundle("com.properties.Zoo",locale);
		/*
		 * there is no "hello" key in Zoo_en_CA, so it goes UP the chain to check
		 * Zoo_en and there is a "hello" key in that file and will print out
		 * "hello in english"
		 */
		System.out.println(rb.getString("hello"));
		/*
		 * there is no "name" key in Zoo_en_CA, goes up the chain and no "name" key in
		 * Zoo_en and then goes up the chain once more to Zoo and there is a "name" key
		 * in Zoo.properties and the value is "Dublin Zoo"
		 */
		System.out.println(rb.getString("name"));
		/*
		 * there is a "visitor" key in Zoo_en_CA and will use the value
		 * "english canada visitor"
		 */
		System.out.println(rb.getString("visitor"));
		/*
		 * there is a "test" key in every file, but it looks for its closet match, 
		 * which is Zoo_en_CA and will print off "english canada test"
		 */
		System.out.println(rb.getString("test"));
		
	}

}

/*
 * Set<Type>setType=new HashSet<>(Arrays.asList(Type.values()));
		List<Animal>animalList=setType.stream().
				map(k->new Animal(++counter,k)).
				collect(Collectors.toList());
				*/
