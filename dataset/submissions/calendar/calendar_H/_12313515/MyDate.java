import java.time.*;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public void addDays(int days){
        LocalDate date =LocalDate.of(year,month,day);
        LocalDate newDate=date.plusDays(days);
        this.year=newDate.getYear();
        this.month=newDate.getMonthValue();
        this.day=newDate.getDayOfMonth();
    }
    public static int difference(MyDate date1, MyDate date2){
        LocalDate date01=LocalDate.of(date1.year,date1.month,date1.day);
        LocalDate date02=LocalDate.of(date2.year,date2.month,date2.day);
        int t= (int)ChronoUnit.DAYS.between(date02,date01);
        return t;
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d",year,month,day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
