import  java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class MyDate implements Comparable<MyDate> {

    private   int year;
    private  int month;
    private  int day;



    public MyDate(int year, int month, int day){
         this.year=year;
        this.month=month;
        this.day=day;
    }

    public void addDays(int days) {
        LocalDate   date   =   LocalDate.of(year,   month,   day);
        LocalDate   newDate   =   date.plusDays(days);
year=newDate.getYear();
        month=newDate.getMonthValue();
        day=newDate.getDayOfMonth();
    }



    public String toString(){

        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
LocalDate date3=LocalDate.of(date1.year,date1.month,date1.day);
        LocalDate date4=LocalDate.of(date2.year,date2.month,date2.day);
   int  daysBetween  =  (int)ChronoUnit.DAYS.between( date3,date4);
       return -daysBetween;
     }

    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }

    @Override
    public int compareTo(MyDate o) {
        var b1 = Integer.compare(o.year, year);
        var b2 = Integer.compare(o.month, month);
        var b3 = Integer.compare(o.day, day);
        return b1 == 0 ? b2 == 0 ? b1 : b2 : b3;
    }
}
