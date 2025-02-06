import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class MyDate {

    private int year = 1997;
    private int month = 1;
    private int day =1;


    private void setYear(int year){
        this.year = year;
    }

    private int getYear(){
        return this.year;
    }

    private void setMonth(int month){
        this.month = month;
    }

    private int getMonth(){
        return this.month;
    }

    private void setDay(int day){
        this.day = day;
    }

    private int getDay(){
        return this.day;
    }

    public long getMill(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTimeInMillis();
    }

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        this.setYear(calendar.get(Calendar.YEAR));
        this.setMonth(calendar.get(Calendar.MONTH) + 1);
        this.setDay(calendar.get(Calendar.DAY_OF_MONTH));
    }


    public String toString(){
        return year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
    }

    public static int difference(MyDate date1, MyDate date2){
        LocalDate d1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate d2 = LocalDate.of(date2.year, date2.month, date2.day);
        return (int)ChronoUnit.DAYS.between(d2, d1);
    }

}
