package q1;
import java.time.LocalDate;
/**
 * this class creates a date - we can have dates objects!
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 */
public class MyDate {
    private int day,month,year;
    //Constructors
    /**
     * Default constractor creates the date of today
     * @param now is the date of today (day of running code, local date of Israel)
     */
    public MyDate(){
        LocalDate now=LocalDate.now();
        this.day = now.getDayOfMonth();
        this.month=now.getMonthValue();
        this.year=now.getYear();
    }
    /**
     * Creates a new date according to given {@code day}/{@code month}/{@code year}
     * <p>
     * if the date is invalid then
     * @param day as {@code int} to be given the default value.
     * @param month as {@code int} to be given the default value.
     * @param year as {@code int} to be given the default value.
     * @param now is todays date
     */
    public MyDate(int d, int m, int y){
            if(validChecker(d,m,y) == true){
                day = d;
                month = m;
                year = y;
            }
            else {
                /*day = 16;
                month = 3;
                year = 2022;  */
                LocalDate now=LocalDate.now();
                this.day = now.getDayOfMonth();
                this.month=now.getMonthValue();
                this.year=now.getYear();  
        }
    }
    /**
    * Copy constructor creates a new date based on an other date
    * @param other {@code MyDate} to copy.
    */
    public MyDate(MyDate other){
        day = other.day;
        month = other.month;
        year = other.year;
    }

    /** 
     * Set method for changing the day of the day
     * @param day is to be given as {@code int}
     * @return true if day change was succesful otherwise false
     */

    public boolean setDay(int d){ 
        day = d; 
        if(day == d) return true;
        else return false;}

    /** 
     * Set method for changing the day of the day
     * @param month is to be given as {@code int}
     * @return true if month change was succesful otherwise false
     */

    public boolean setMonth(int m){ 
        month = m; 
        if(month == m) return true;
        else return false;}
    
    /** 
     * Set method for changing the day of the day
     * @param year is to be given as {@code int}
     * @return true if year change was succesful otherwise false
     */

    public boolean setYear(int y){ 
        year = y; 
        if(year == y) return true;
        else return false;}

    /** 
     * Checks if this date is equal to another date.
     * <p>
     * Compares this {@code MyDate} another date.
     * <p>
     * Only objects of the type {@code MyDate} can be compared, any other types will return false.
     * @param other the other that is to be checked
     * @return true if other is equal to this date otherwise return false
     */

    public boolean equals(MyDate other){
        if(!(other instanceof MyDate) || other == null){
            return false;
        }
        if(compareDate(other) == 0) return true;
        else return false;
    }

    /**
     * checks if {@code day}/{@code month}/{@code year} is a valid date
     * <p>
     * returns true if day, month and year are in the valid ranges otherwise returns false
     */

    public boolean validChecker(int d, int m, int y){
        if(y > 2100 || y < 1900) return false;
        switch(m) {
            case 1:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
                }
            case 2:
                if(d <= 28 && isLeapYear() == false){
                    return true;
                }
                else if(d <= 29 && isLeapYear() == true){
                    return true;
                }
                else {
                    return false;
                }
            case 3:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
                }
            case 4:
                if(d <= 30){
                    return true;
                }
                else {
                    return false;
                }
            case 5:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
                }
            case 6:
                if(d <= 30){
                    return true;
                }
                else {
                    return false;
                }
            case 7:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
                }
            case 8:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
                }
            case 9:
                if(d <= 30){
                    return true;
                }
                else {
                    return false;
                }
            case 10:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
                }
            case 11:
                if(d <= 30){
                    return true;
                }
                else {
                    return false;
                }
            case 12:
                if(d <= 31){
                    return true;
                }
                else {
                    return false;
            }
            default:
                return false;
          }
    }
    /** 
     * Returns the date's day.
     * @return this date's day as an {@code int}
     */
    public int getDay(){ return day;}
    /** 
     * Returns the date's month.
     * @return this date's month as an {@code int}
     */
    public int getMonth(){ return month;}
    /** 
     * Returns the date's year.
     * @return this date's year as an {@code int}
     */
    public int getYear(){ return year;}
    /**
     * Returns the date in a {@code dd}/{@code mm}/{@code yyyy} format.
     * @param d_str is a format of DD
     * @param m_str is format of MM
     * @param y_str is format of YYYY
     */
    public String toString() {
        String d_str = String.format("%02d", day);
        String m_str = String.format("%02d", month);
        String y_str = String.format("%04d", year);
        String str = d_str+"/"+m_str+"/"+y_str;
        return str;
    }
        // Print and display the formatted string
        //System.out.println(str);
        //if(month < 10){
           // return day + "/0" + month + "/" + year;
        //return day + "/" + month + "/" + year;}

    /**
     * @param d_str is a format of DD
     * @param m_str is format of MM
     * @param y_str is format of YYYY
     * Prints the date in a {@code dd}/{@code MM}/{@code yyyy} format.
     */
    public void printDate() { 
        String d_str = String.format("%02d", day);
        String m_str = String.format("%02d", month);
        String y_str = String.format("%04d", year);
        String str = d_str+"/"+m_str+"/"+y_str;
        System.out.println(str);
        
        //if(month < 10){
          //  System.out.println(year + "/0" + month + "/" + day);
        }
        //System.out.println(day + "/" + month + "/" + year);}

    /**
     * Prints the date in a {@code dd}/{@code Verbal month name}/{@code yyyy} format.
     */
    
    public void printMonthName(){
        switch(month) {
            case 1:
                System.out.println(day + " January " + year);
                break;
            case 2:
                System.out.println(day + " February " + year);
                break;
            case 3:
                System.out.println(day + " March " + year);
                break;
            case 4:
                System.out.println(day + " April " + year);
                break;
            case 5:
                System.out.println(day + " May " + year);
                break;
            case 6:
                System.out.println(day + " June " + year);
                break;
            case 7:
                System.out.println(day + " July " + year);
                break;
            case 8:
                System.out.println(day + " August " + year);
                break;
            case 9:
                System.out.println(day + " September " + year);
                break;
            case 10:
                System.out.println(day + " October " + year);
                break;
            case 11:
                System.out.println(day + " November " + year);
                break;
            case 12:
                System.out.println(day + " December " + year);
                break;
            default:
                System.out.println("Invalid date!");
                break;
          }
    }
    /** 
     * Returns the number of days in this date's montgh
     * @return {@code int} number representing the number of days in the month.
     */
    public int getMonthDay(){
        switch(month) {
            case 1:
                return 31;
            case 2:
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
          }
    }

    /** 
     * Checks if the date's year is a leap year.
     * @return true if year is a leap year, otherwise false.
     */

    public boolean isLeapYear(){
        if(year % 100 == 0 && year % 400 == 0){
            return true;
        }
        else return year % 4 == 0;
    }

    /** 
     * Returns a the date after the date of {@code MyDate}.
     * <p>
     * @return a {@code MyDate} based on the next date of this date.
     */

    public MyDate nextDate(){
        MyDate nextDay = new MyDate();
        switch(month) {
            case 1:
                if(day == 31){
                    nextDay = new MyDate(1,2,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 2:
                if(day == 28 && isLeapYear() == false){
                    nextDay = new MyDate(1,3,year);
                    return nextDay;
                }
                else if(day == 28 && isLeapYear() == true){
                    nextDay = new MyDate(29,2,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 3:
                if(day == 31){
                    nextDay = new MyDate(1,4,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 4:
                if(day == 30){
                    nextDay = new MyDate(1,5,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 5:
                if(day == 31){
                    nextDay = new MyDate(1,6,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 6:
                if(day == 30){
                    nextDay = new MyDate(1,7,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 7:
                if(day == 31){
                    nextDay = new MyDate(1,8,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 8:
                if(day == 31){
                    nextDay = new MyDate(1,9,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 9:
                if(day == 30){
                    nextDay = new MyDate(1,10,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 10:
                if(day == 31){
                    nextDay = new MyDate(1,11,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 11:
                if(day == 30){
                    nextDay = new MyDate(1,12,year);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
                }
            case 12:
                if(day == 31){
                    nextDay = new MyDate(1,1,year + 1);
                    return nextDay;
                }
                else {
                    nextDay = new MyDate(day + 1,month,year);
                    return nextDay;
            }
            default:
                return nextDay;
          }
    }

    /** 
     * Prints this date in according to the given format.
     * <p>
     * Default format is the dd/mm/yyyy format.
     * <p>
     * Possible formats are:
     * <p>
     * {@code ddmmyy}
     * <p>
     * {@code ddmmyyyy}
     * <p>
     * {@code mmddyyyy}
     * <p>
     * {@code yyyymmdd}
     * <p>
     * {@code ddMMyy}.
     * @param format a {@code string} representing the requested format. 
     */

    public void printFormatDate(String format){
        switch(format){
            case "ddmmyy":
                if(month < 10){
                    System.out.println(day + "/0" + month + "/" + year%100 );
                }
                else 
                    System.out.println(day + "/" + month + "/" + year%100);
                break;
            case "ddmmyyyy":
                if(month < 10){
                    System.out.println(day + "/0" + month + "/" + year);
                }
                else 
                    System.out.println(day + "/" + month + "/" + year);
                break;
            case "mmddyyyy":
                if(month < 10){
                    System.out.println("0" + month + "/" + day + "/" + year);
                }
                else 
                    System.out.println(month + "/" + day + "/" + year);
                break;
            case "yyyymmdd":
                if(month < 10){
                    System.out.println(year + "/0" + month + "/" + day);
                }
                else 
                    System.out.println(year + "/" + month + "/" + day);
                break;
            case "ddMMyyyy":
                printMonthName();
                break;
            default:
                System.out.println("Invalid format!");;
        }
    }

    /** 
     * Compares {@code MyDate} object with one an other 
     * <p>
     * Checks whether the date are the same, come one after an other or the opposite
     * @param other the other {@code MyDate} to compare with.
     * @return 0 if the dates are equal, -1 if this date is before the other date, 1 if this date is after the other date.
     */

    public int compareDate(MyDate date){
        if(day == date.day && month == date.month && year == date.year){
            return 0;
        }
        if(date.year > year){
            return -1;
        }
        else if(date.year == year && date.month > month){
            return -1;
        }
        else if(date.year == year && date.month == month && date.day > day){
            return -1;
        }
        else return 1;
    }
}
