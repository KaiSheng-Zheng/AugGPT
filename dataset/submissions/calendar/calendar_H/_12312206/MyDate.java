import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private int year;
    private int month;
    private int day;

    private String name;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public void addDays(int days) {
        LocalDate now = LocalDate.of(year, month, day);
        LocalDate just=now.plusDays(days);
        this.year = just.getYear();
        this.month= just.get(ChronoField.MONTH_OF_YEAR);
        this.day= just.getDayOfMonth();
    }

     public LocalDate getMyDate(MyDate date){
        LocalDate a= LocalDate.of(year, month, day);
        return a;
    }

    public String toString() {
        LocalDate now1 = LocalDate.of(year, month, day);
return  now1.toString();
    }

    public static int difference(MyDate date2, MyDate date1) {
        LocalDate localDate=date1.getMyDate(date1);
        long val=localDate.until(date2.getMyDate(date2) , ChronoUnit.DAYS);
        return  (int)val;
    }

}