package com.nighthawk.spring_portfolio.mvc.calendar;

// Prototype Implementation
import java.util.*;
import java.time.*;
public class APCalendar {

    public static boolean isLeapYear(int year) {
        if((year % 4) == 0){
            return true;
        }else{
            return false;
        }
    }

    private static int firstDayOfYear(int year) {
        Calendar calenobj = Calendar.getInstance();
        calenobj.add(Calendar.YEAR, year);
        calenobj.add(Calendar.MONTH, 0); //month begins on index 0
        calenobj.add(Calendar.DAY_OF_WEEK, 1);
        //Dictionary/hashmap for the first three letters to numbers
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("Sun",0);
            put("Mon",1);
            put("Tue",2);
            put("Wed",3);
            put("Thu",4);
            put("Fri",5);
            put("Sat",6);
        }};
        String day = (calenobj.getTime()).toString();
        String days = day.substring(0,3);
        return (map.get(days));
    }

    private static int dayOfYear(int month, int day, int year) {
        //create new imported Java object that uses the calendar
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date(year,month-1,day)); //month begins on index 0
        //this method does not require an if statement using isLeapYear 
        return(cal.get(Calendar.DAY_OF_YEAR));
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        int counter = 0;
        for(int i = year1; i <= year2; i++){
            if(isLeapYear(i)){
                counter++;
            }
        }

        return counter;
    }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        Calendar calenobj = Calendar.getInstance();
        calenobj.add(Calendar.YEAR, year);
        calenobj.add(Calendar.MONTH, month - 1); //month begins on index 0
        calenobj.add(Calendar.DAY_OF_WEEK, day);
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("Sun",0);
            put("Mon",1);
            put("Tue",2);
            put("Wed",3);
            put("Thu",4);
            put("Fri",5);
            put("Sat",6);
        }};
        String currentDay = (calenobj.getTime()).toString();
        String days = currentDay.substring(0,3);
        System.out.println(days);
        return (map.get(days));
    }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2022));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}