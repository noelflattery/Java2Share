package com.android;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.chrono.Era;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.*;
/**
 * this deals with a Three basic types of classes that deal with Time in java, which are 
 * LocalDate //deals with dates
 * LocalTime //deals with times
 * LocalDatetime //deals with dates and times
 * there is a fourth type called ZonedDateTime and it's debatable that Java should be dealing with times zones as there are other
 * technologies more suited to this, but it is covered in this code.
 * @author NoelF
 *
 */
public class Examples {
	/**while if you are doing this course you should be familiar how java 8 deals with Times, we will recap first the
	 * Three date time types
	 * LocalDate
	 * LocalTime 
	 * LocalDateTime
	 * each of these data types know the amount of days in each month, leap years, etc unlike prior to java 8.
	 * there is an additional data typethat deals with Dates and times in differeing time zones, which you will not have dealt with 
	 * before
	 * ZonedDateTime
	 * prior to Java 8 dates and times were extremely cumbersome and awkward to use, with Java 8 there are new classes that simplify the 
	 * previously complicated processes dealing with dates and time.
	 * you don't create a object of any of the four outlined types, you use static methods of each of classes to obtain a date, a time or 
	 * dateTime. i.e {@code 
	 * LocalDate.now()//will return todays date		}
	 * ZonedDateTime deals with timezones and every machine running your code is going to be operating in a particular TimeZone (its usually
	 * based on Region set by the operating system your application is running on, be it windows or unix and also remember that android is a 
	 * version of Unix)
	 * , and like 
	 * LocalDate for instance, you can't create an object of this class, but use static methods i.e {@code 
	 * ZonedDateTime.now()}will return the date and time and timezome of the machine that is running your appication{@code 
	 * 2020-08-20T18:25:14.859+01:00[Europe/London]}
	 * thats the region set on this machine (even though i am based in Ireland and you can change this and with the advent of Brexit if you 
	 * are in the Eu you probably should). Each of these TimeZones are uniquely identified by a ZoneID, which for example we show
	 * the ZoneId for Dublin, Ireland {@code
	 * Europe/Dublin}
	 * You can show the time in a particular timezone, relative to a another timezome as well
	 */
	static void ex1() {
		System.out.println("Dates and times");
		/*
		 * there are three basic time types in Java
		 * LocalDate
		 * LocalTime
		 * LocalDateTime
		 * there is a fourth type called
		 * ZonedDateTime, which oracle recommends you avoid using unless you really have too
		 */
		System.out.println("todays date is "+LocalDate.now());//YYYY-mm-dd
		System.out.println("the time is now "+LocalTime.now());//hr:mm:ss:ns
		System.out.println("the date and time of now is "+LocalDateTime.now());//YYY-mm-dd T hr:mm:ss:ns
		/*
		 * you can't create any of the time types by using the keyword new, you have to use one of the 
		 * static methods to create a LocalDate,LocalTime or LocalDateTime
		 * for instance for LocalTime
		 * .now() is a static method that returns the current time as a new DateTime
		 */
		//LocalDate d1=new LocalDate();
		/*
		 * this prints off the current time and the Locale of the machine this code is running on,
		 * in this case its Europe/London
		 */
		System.out.println(ZonedDateTime.now());
		//there is no ZonedDate
	//	System.out.println(ZonedDate.now());
		//there is not ZonedTime
	//	System.out.println(ZonedTime.now());
		//this takes three ints, first int is year, second int is month, third int is date
		LocalDate date1=LocalDate.of(2022, 1, 30);//months and dates start at 1
		LocalDate date2=LocalDate.of(2222, Month.AUGUST, 8);
		Month myMonth=Month.APRIL;//will compile
	//	Month myMonth2=3;//will not compile
	//	Day myDay;
		//there is a year type
		Year myYear=Year.of(1999);//
		System.out.println(myYear.isLeap());
		myYear=Year.of(2020);
		System.out.println(myYear.isLeap());
		Era myEra;//this can be any lenght of dates
		
		System.out.println("times");
		/*
		 * times can vary in levels of details
		 */
		LocalTime time1=LocalTime.of(14, 15);//hours and minutes
		System.out.println(time1);
		LocalTime time2=LocalTime.of(4, 15, 25);//hours minutes and seconds
		System.out.println(time2);
		LocalTime time3=LocalTime.of(13, 20,45,89);//hours minutes secons and nanosecond (billionith of a second)
		System.out.println(time3);
		//java 8 recognises leap years
		date1=LocalDate.of(2020, Month.FEBRUARY, 29);
		
		LocalDateTime ldt1=LocalDateTime.of(3045,Month.DECEMBER,30,20,15,45,1000);
		System.out.println(ldt1);
		//combination of localdate and localtime to create a localDateTime
		LocalDateTime ldt2=LocalDateTime.of(date1, time2);
		
		System.out.println("TimeZones");
		/*
		 * TimeZones have they're own data type ZoneId
		 * this class has a number of static methods, just like the localDAte, localTime, LocalDateTime
		 * you can' create a timezone by using the "new" keyword
		 * 
		 */
		System.out.println("SystemDefault");
		System.out.println("this is getting the timezone your application is running on");
		System.out.println("timezone on this machine is "+ZoneId.systemDefault());
		System.out.println("display all timezones");
		System.out.println("getAvailableZoneIds");
		//this returns a Set of all the avaiable timezones
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println("count of timezones");
		System.out.println(ZoneId.getAvailableZoneIds().stream().count());//600 in total
		ZoneId.getAvailableZoneIds().stream().
		sorted().
		
		forEach(System.out::println);
		//this will be all the timezones for Europe
		List<String>timeZones=ZoneId.getAvailableZoneIds().
		stream().
		filter(s->s.contains("Europe")).
		sorted().
		collect(Collectors.toList());
		System.out.println(timeZones);
		System.out.println("timezones for Ireland (not that bullshit eire)");
		ZoneId.getAvailableZoneIds().
		stream().
		filter(s->s.contains("Eire")).
		/*
		 * this does not include Europe/Dublin or Europe/Belfast, but i would imagine they would be the
		 * same
		 */
		sorted().forEach(System.out::println);
		System.out.println("timezone of shanghai*******");
		ZoneId shaZone=ZoneId.of("Asia/Shanghai");//.getAvailableZoneIds();
		//just prints out Asia/Shanghai
		System.out.println(shaZone);
		System.out.println("ZonedDateTime");
		
		ZoneId irish=ZoneId.of("Europe/Dublin");
		ZonedDateTime irishZone=ZonedDateTime.of(LocalDateTime.now(),irish);
		System.out.println("irish time, date and zone");
		System.out.println(irishZone);
		System.out.println("new york time");
		//this is five hour behind current Irish time
		System.out.println(irishZone.withZoneSameInstant(ZoneId.of("US/Eastern")));
		//8 hours ahead of current irish time
		System.out.println("shangHai time");
		System.out.println(irishZone.withZoneSameInstant(ZoneId.of("Asia/Shanghai")));
		/*
		 * this is a date and time in the future in the Asia/Shanghai timezone
		 */
		date1=LocalDate.of(2035, Month.JUNE, 20);
		time1=LocalTime.of(14, 35);
		ZonedDateTime china1=ZonedDateTime.of(date1, time1,shaZone);
		System.out.println("china");
		System.out.println(china1);
		System.out.println("instant of the time in Dublin");
		System.out.println(china1.withZoneSameInstant(ZoneId.of("Europe/Dublin")));
		System.out.println("instant of the time in new York");
		System.out.println(china1.withZoneSameInstant(ZoneId.of("US/Eastern")));
		System.out.println(china1.getOffset());
		System.out.println("end");
		
	//	minus(zoned1.getOffset());	
	}
	/**
	 *this covers the various methods we have for adding and subtracting hours, minutes, days, seconds, weeks, years, months
	 *and how these methods can be chained
	 *etc and also some of the rules for adding to dates and times. 
	 */
	static void ex2() {
		System.out.println("dates and times revision");
		System.out.println("plus time periods");
		LocalDate d1=LocalDate.now();
		System.out.println("todays date "+d1);
		d1=d1.plusDays(2);
		System.out.println(d1);
		d1=d1.plusWeeks(4);
		System.out.println(d1);
		d1=d1.plusMonths(2);
		System.out.println(d1);
		d1=d1.plusYears(4);
		System.out.println("minus time periods");//operate exact same way as plsu
		d1=d1.minusWeeks(3);
		
		d1=LocalDate.now();
		//you can chain the minus and plus method
		d1=d1.minusMonths(2).minusWeeks(2).minusYears(4).plusYears(4);
		System.out.println(d1);
		/*
		 * you add and subtract hours, minutes, seconds, nanaoseconds to a time and dateTime
		 * can add days, months, year  to a date and a datetime
		 * can't add days, months years to a time
		 * can't add hours, minutes, seconds nanoseconds to a date
		 */	
	}
/**
 *This method deals with first periods, which are for Dates and are used to store a unit of time duration that relates to dates.
 *i.e Period.ofDays(4) and Period.ofMonths()
 */
	static void ex3() {
		System.out.println("periods ");
		/*
		 * periods work for dates
		 * when we ran this it was 29th january 2020
		 * if we leave in plusdays(2) we get
		 * date is 2020-01-31
				date is 2020-02-29
				date is 2020-03-29
				date is 2020-04-29
				as there is no 31 of feb, so goest first to the end of february and then goest to 29 of every
				other month
				otherwise this just increments by months
		 */
		LocalDate start=LocalDate.now();//.plusDays(2);
		LocalDate finish=start.plusMonths(10);
		while(start.isBefore(finish)) {
			System.out.println("date is "+start);
			start=start.plusMonths(1);
		}
		/*
		 * we can use periods to define a set amount of Days, Months
		 */
		Period p1=Period.ofMonths(2);//.ofDays(4);
		LocalDate today=LocalDate.now();
		//you cannot know the exact time period of a period until you use it with a date
		//it could be 61 days, could be 62, could 60 days for a leap year and 59 for a non leap year
		System.out.println("two months in the future");
		System.out.println(today.plus(p1));
		/*
		 * methods of period and duration CANNOT be chained, it merely takes the last method in the chain, 
		 * which in this case is ofDAys(2) so this duration is of only 2 days
		 */
		p1=Period.ofMonths(34).ofWeeks(12).ofMonths(98).ofDays(2);
		System.out.println("2 days in the future");
		System.out.println(today.plus(p1));
		
		System.out.println("Durations");
		System.out.println("duration for time");
		//just like periods you can't chain them, this is only a duration of 30 minutes
		Duration dur1=Duration./*ofHours(2).*/ofMinutes(30);
		System.out.println(LocalTime.now().plus(dur1));
		LocalTime now=LocalTime.now();
		/*
		 * this loop goes 100, but localTime does not display any dates, so this
		 * goes forward 96 times, which is 48 hours, so it's the same time, two days in the future. but 
		 * localTime cannot display dates, so four more iterations of the loop will give 2 hours in the
		 * future
		 */
		for(int i=0;i<100;i++) {//t
			now=now.plus(dur1);
		}
		System.out.println(now);//two hours in the future
		Duration dur2=Duration.ofMinutes(30);
		
		LocalDateTime dateTimeNow=LocalDateTime.now();
		for(int i=0;i<100;i++) {
			dateTimeNow=dateTimeNow.plus(dur1);
		}
		System.out.println("50 hours from now is "+dateTimeNow);
		
		System.out.println(dur1);
		//p1 was originally 2 days, now it's 36 months and 2 days
		p1=p1.plusMonths(36);
		System.out.println(p1);//this is a period of 4 months and 2 days
		//displayerd as P36M2D
		System.out.println(p1.getMonths());//this will display 4
		System.out.println(p1.getDays());//this will display 2
		/*
		 * periods do not store weeks, only months, days and years
		 */
		p1=p1.plusYears(5);
		//this is now P5Y36M2D which is 5 years 4 months and 2 days
		System.out.println(p1);
		System.out.println(p1.getYears());
		
		Period per2=Period.ofWeeks(4);
		/*
		 * a period of weeks is stored as days
		 */
		System.out.println("per2 is 4 weeks which is "+per2);
		System.out.println("period between two dates");
		LocalDate future=today.plusMonths(4).plusYears(3).plusWeeks(19).plusDays(678);
		System.out.println(future);
		Period between =Period.between(today, future);
		System.out.println(between);
		/*
		 * to check that this is right, we add this period onto todays date and we shoudl get the same
		 * future date
		 */
		System.out.println(today.plus(between));
	
	}
	
	static void ex4() {
		System.out.println("different types of duration (times)");
		/*
		 * durations are times
		 * so if you have a duration of days, this will print out hours
		 */
		Duration daily=Duration.ofDays(2);//PT48H
		System.out.println(daily);
		Duration hourly=Duration.ofHours(2);//
		System.out.println(hourly);//PT2H
		//any duration longer than a hour, and if you use ofMinutes, will be stored as hours
		Duration everyMinute=Duration.ofMinutes(5999);//PT99H59M
		System.out.println(everyMinute);
		Duration every10Seconds=Duration.ofSeconds(10);
		System.out.println(every10Seconds);
		/*
		 * as soon as seconds reaches 60, that becomes a minute
		 * as soon as seconds reaches 3600, that become an hour
		 * so 3661 seconds becomes 
		 * 1 hour
		 * 1 minute
		 * 1 second
		 */
		Duration lotSeconds=Duration.ofSeconds(3661);//PT1H1M1S
		System.out.println(lotSeconds);
		Duration.ofNanos(1000);//billioniths of a second
		Duration.ofMillis(100);//thousandth of a second
		/*
		 * 
		 */
		daily=Duration.of(1, ChronoUnit.DAYS);
		hourly=Duration.of(1, ChronoUnit.HOURS);
		/*
		 * Duration only works for times, once you gove over days this will not work
		 */
	//	Duration years=Duration.of(1, ChronoUnit.MONTHS);//will not compile
	//	System.out.println(years);
		System.out.println(hourly);//7,000 years
		every10Seconds=Duration.of(10, ChronoUnit.SECONDS);
		
		LocalTime midnight=LocalTime.MIDNIGHT;//midnight is the first nanaosecond of the new day
		LocalTime now=LocalTime.now();
		System.out.println("time to midnight");
		System.out.println(midnight);
		System.out.println(now);
		//this produces a long
		System.out.println(ChronoUnit.SECONDS.between(now, midnight));//the amount of seconds from midnight
	//	System.out.println(Duration.of(1, ChronoUnit.SECONDS.between(now, midnight)));
		//which can be used with of
		/*
		 *ChronoUnit.SECONDS.between(now, midnight) produces a long which is the amount of seconds since
		 *midnight (midnight is the first nanosecond of the new day)
		 *second argument  ChronoUnit.SECONDS
		 *is the lowest time period we want to display, so this will display hours, minutes and seconds
		 */
		System.out.println(Duration.of(ChronoUnit.SECONDS.between(now, midnight), ChronoUnit.SECONDS));
		
		LocalDateTime td1=LocalDateTime.now();
		LocalDateTime td2=td1.plusDays(13).plusHours(100).plusMinutes(20);
		System.out.println(td1);
		System.out.println(td2);
		
		System.out.println(ChronoUnit.MINUTES.between(td1, td2));
		System.out.println(ChronoUnit.DAYS.between(td1, td2));
		
		td2=td1.plusWeeks(100).plusMonths(50).plusDays(100).plusYears(70);
		System.out.println(ChronoUnit.MINUTES.between(td1, td2));
		System.out.println(ChronoUnit.YEARS.between(td1, td2));
		/*
		 * you can use durations with LocalTimes and localDateTimes but you can't use durations
		 * with localDates
		 * every10Seconds is a duration, so we can add this to a LocalDateTime
		 * these are localDateTimes and you CAN chain these
		 */
		System.out.println(td1.plus(every10Seconds));//this is 10 seconds in future
		System.out.println(td1.plus(every10Seconds).plus(every10Seconds));//this is 20 seconds in the future
		//we can't add it to LocalDate
		//LocalDate.now().plus(every10Seconds);
		/*
		 * Periods don't take chronoUnits
		 */
	//	Period per1=Period.of(years, months, days)
	
	}
	
	static  void ex5() {
		System.out.println("Instant");
		/*
		 * Instant is a particular point in time in the GMT time zone
		 * so for instance if the current GMT time is 13:00 this will be the same on a machine in Tokyo,
		 * in Dublin and in Los Angeles
		 */
		Instant now=Instant.now();
		System.out.println(now);
		
		long j=0;
		for(long i=0;i<1_200_000_000;i++) {
			j=j+1;
		}
		System.out.println(j);
		Instant later=Instant.now();
		Duration duration=Duration.between(now, later);
		System.out.println(duration.toMillis());
		now=Instant.now();
		/*
		 * comment this in to see how long it takes a stream to create 1.2 billion Integer wrapper objects
		 * and count them, approx 9 seconds
		 */
	//	Stream.iterate(0, n->n+1).limit(1200000000).count();
		later=Instant.now();
		System.out.println(Duration.between(now, later).toMillis());
		
		LocalDateTime ldt1=LocalDateTime.of(LocalDate.now().plusDays(27),LocalTime.now().plusMinutes(72));
		System.out.println("a local Date");
		System.out.println(ldt1);
		/*
		 * this is the offset for paris, paris is one hour ahead of GMT
		 * we are assuming the above date was on a machie in paris
		 */
		ZoneOffset zOffset=ZoneOffset.ofHours(-1);//this is the offset for paris
		System.out.println(ldt1.toInstant(zOffset));//this will be GMT, which is instant time
		
		
		LocalDate date=LocalDate.of(2022, Month.JULY, 2);
		LocalTime time=LocalTime.of(14, 25);
		ZoneId zone=ZoneId.of("Asia/Shanghai");
		
		
		
		/*
		 * this is creating a ZoneDateTime that will be give us
		 * 2022-07-02T14:25+08:00[Asia/Shanghai]
		 * 7th July 2022 2:25 in the afternoon in Shanghai
		 * +8, means it 8 hours ahead of GMT
		 */
		ZonedDateTime zonedDateTime=ZonedDateTime.of(date,time,zone);
		System.out.println(zonedDateTime);
		/*
		 * this creates the GMT for this particular time in shangHai
		 */
		Instant instant2=zonedDateTime.toInstant();
		/*
		 * this will be now
		 * 2022-07-02T06:25:00Z
		 * 22nd July 2022 6:25 in the morning in London
		 */
		System.out.println(instant2);
		
		zone=ZoneId.of("Asia/Shanghai");
		System.out.println(LocalDateTime.now());
		zonedDateTime=ZonedDateTime.of(LocalDateTime.now(),zone);
		System.out.println("current time in shanghai");
		/*
		 * this is merely the current time, ie. 14:15 applied to shanghai timezone so this will print out
		 * 2020-01-30T14:12:34.418+08:00[Asia/Shanghai]
		 * which is 2:12 in the afternoon
		 */
		System.out.println(zonedDateTime);
		/*
		 * the GMT time when it was 2:12 in shanghai was 8 hours before which will be
		 * 6:12 in the morning
		 */
		instant2=zonedDateTime.toInstant();
		System.out.println(instant2);	
	}

}
