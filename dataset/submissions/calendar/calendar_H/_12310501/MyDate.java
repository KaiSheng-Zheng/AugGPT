import java.lang.Math;

public class MyDate{
    public static final int[] normalYearCumulativeDays = {0,31,59,90,120,151,181,212,243,273,304,334,365};
    public static final int[] leapYearCumulativeDays = {0,31,60,91,121,152,182,213,244,274,305,335,366};
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){
        //Total days to go, start from 1 Jan of the start-year
        days += normalYearCumulativeDays[this.month-1] + this.day;

        //find total leap days within the interval(year1, year2-1), (might exceed the real value by one)
        int leapDays = LeapDaysInInterval(this.year, this.year + (int)days/365, this.month);
        days -= leapDays;

        //Update Year and calculate remaining days
        this.year += (int)days/365;
        days %= 365;
        
        if(days == 0){
            this.year--;
            days = 365;
        }

        //Find the largest cumulative days less than remaining days to find the month and day
        int[] currentYearCumulativeDays = normalYearCumulativeDays;
        if(isLeapYear(this.year)){ 
            currentYearCumulativeDays = leapYearCumulativeDays; 
            days++; 
        }

        this.month = 1;
        for(;this.month <= 12; this.month++){
            if(currentYearCumulativeDays[this.month] >= days){
                days -= currentYearCumulativeDays[this.month - 1];
                this.day = days;
                break;
            }
        }
    }

    public String toString(){
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    public static int difference(MyDate date1, MyDate date2){
        MyDate firstDate = date1, lastDate = date2; //firstDate contain smaller date
        
        if(!(isDate1Earlier(date1, date2))){
            firstDate = date2;
            lastDate = date1;
        }

        //Find total leap days
        int leapDays = LeapDaysInInterval(firstDate.year, lastDate.year, firstDate.month);
        //If the latest date cannot surpass 29 Feb in a leap year, leapDays -1
        if(lastDate.month < 3 && isLeapYear(lastDate.year)){
            leapDays--;
        }
        
        //Using Finite Integral Logic
        int difference = 365 * (lastDate.year-firstDate.year);
        difference += (normalYearCumulativeDays[lastDate.month-1] + lastDate.day);
        difference -= (normalYearCumulativeDays[firstDate.month-1] + firstDate.day);
        difference += leapDays;
        
        if(difference < 0){
            difference = 0;
        }
        
        if(isDate1Earlier(date1, date2)){
            difference *= -1;
        }

        return difference;
    }

    private static boolean isDate1Earlier(MyDate date1, MyDate date2){
        if(date2.year > date1.year){
            return true;
        }
        else if(date2.year == date1.year){
            int difference = normalYearCumulativeDays[date2.month-1] + date2.day;
            difference -= (normalYearCumulativeDays[date1.month-1] + date1.day);
            return (difference > 0);
        }
        return false;
    }

    private static boolean isLeapYear(int year){
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    private static int LeapDaysInInterval(int year1, int year2, int month1){
        int leapDays = 0;
    
        //Removing invalid initial leap Year
        if(year1 % 4 == 0 && month1 > 2){ leapDays--; }
        
        //Find first Leap year within the interval
        for(; year1 < year2 && year1 % 4 != 0; year1++){}
        
        //Calculate total leap days
        if(year1 % 4 == 0){ 
            leapDays++; 
            leapDays += (int)(year2-year1)/4;
        }

        //The rest of the method : Removing leap days which (% 100 == 0 but % 400 != 0)
        year1 = 100 * (int)Math.ceil((double)year1/100);

        //Find first invalid leap year
        for(; year1 <= year2 && year1 % 400 != 0; year1 += 100){
            leapDays--;
        }
        
        if(year1 < year2){
            leapDays -= ((int)(year2-year1)/100 - (int)(year2-year1)/400);
        }
        
        return leapDays;
    }
}