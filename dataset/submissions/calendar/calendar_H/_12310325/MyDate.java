//package A4;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getDay() {return day;}

    public int getMonth() {return month;}
    public int getYear(){return year;}
    public void set(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setDay(int day){this.day = day;}
    public void setMonth(int month){this.month = month;}

    public void setYear(int year) {this.year=year;}
    public LocalDate Traslate(){
        LocalDate Date = LocalDate.of(getYear(),getMonth(),getDay());
        return Date;
    }

    public void addDays(int days){
        LocalDate date = Traslate();
        LocalDate newDate = date.plusDays(days);
        setYear(newDate.getYear());
        setMonth(newDate.getMonthValue());
        setDay(newDate.getDayOfMonth());
    }
    public String toString(){
        String m;
        String d;
        if (getMonth()<=9){
            m = "0"+getMonth();
        }
        else {
            m = String.valueOf(getMonth());
        }
        if (getDay()<=9){
            d = "0"+getDay();
        }
        else {
            d = String.valueOf(getDay());
        }
        return String.format("%d-%s-%s",getYear(),m,d);
    }
    public static int difference(MyDate date1,MyDate date2){
        LocalDate Date1= date1.Traslate();
        LocalDate Date2= date2.Traslate();
        long days = ChronoUnit.DAYS.between(Date2, Date1);
        int intValue = (int) days;
        return intValue;


    }
}
