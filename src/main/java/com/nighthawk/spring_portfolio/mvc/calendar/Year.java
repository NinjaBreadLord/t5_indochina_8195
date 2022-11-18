package com.nighthawk.spring_portfolio.mvc.calendar;

/**
 * Simple POJO
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private boolean isLeapYear;
   private int firstDayOfYear;
   private int dayOfYear;
   private int numberOfLeapYears;
   private int dayOfWeek;

   // zero argument constructor
   public Year() {
   }

   /* year getter/setters */
   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.setFirstDayOfYear(year);
      // this.setDayOfYear(month, day, year);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }

   private void setIsLeapYear(int year) { // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   public int numberOfLeapYears(int year1, int year2) {
      return APCalendar.numberOfLeapYears(year1, year2);
   }

   public void setnumberOfLeapYears(int year1, int year2) { // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.numberOfLeapYears(year1, year2);
   }

   public int getFirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }

   public void setFirstDayOfYear(int year) { // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }

   public int getdayOfYear(int month, int day, int year) {
      return APCalendar.dayOfYear(month, day, year);
   }

   public void setdayOfYear(int month, int day, int year) { // this is private to avoid tampering
      this.dayOfYear = APCalendar.dayOfYear(month, day, year);
   }

   public int getdayOfWeek(int month, int day, int year) {
      return APCalendar.dayOfWeek(month, day, year);
   }

   public void setdayOfWeek(int month, int day, int year) { // this is private to avoid tampering
      this.dayOfWeek = APCalendar.dayOfWeek(month, day, year);
   }

   public String isLeapYearToString() {
      return ("{ \"year\": " + this.year + ", " + "\"isLeapYear\": " + this.isLeapYear + " }");
   }

   public String firstDayOfYearToString(int year) {
      return ("{ \"year\": " + this.year + ", " + "\"firstDayOfYear\": " + this.firstDayOfYear + " }");
   }

   public String dayOfYearToString(int month, int day, int year) {
      return ("{ \"month\": " + month + ", " + "\"day\": " + day + ", " + "\"year\": " + this.year + ", "
            + "\"dayOfYear\": " + APCalendar.dayOfYear(month, day, year) + " }");
   }

   public String numLeapYearToString(int year1, int year2) {
      return ("{ \"year1\": " + year1 + ", " + "\"year2\": " + year2 + ", " + "\"numberOfLeapYears\": "
            + APCalendar.numberOfLeapYears(year1, year2) + " }");
   }

   public String dayOfWeekToString(int month, int day, int year) {
      return ("{ \"month\": " + month + ", " + "\"day\": " + day + ", " + "\"year\": " + year + ", " + "\"dayOfWeek\": "
            + APCalendar.dayOfWeek(month, day, year) + " }");
   }

   public String toString() {
      return ("{ \"year\": " + this.year + ", " + "\"firstDayOfYear\": " + this.firstDayOfYear + ", "
            + "\"firstDayOfYear\": " + this.firstDayOfYear + " }");
   }

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2020);
      System.out.println(year);
   }
}