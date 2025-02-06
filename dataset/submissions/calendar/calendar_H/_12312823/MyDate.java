import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }



    public int getMonth() {
        return month;
    }



    public int getDay() {
        return day;
    }



    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        LocalDate startDate = LocalDate.of(year,month, day);
        LocalDate endDate = startDate.plusDays(days);
        year=endDate.getYear();
         month= endDate.getMonthValue();
         day=endDate.getDayOfMonth();
    }





    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }





    public static int difference(MyDate date1, MyDate date2) {
        LocalDate startDate = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
        LocalDate endDate = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());


        int daysBetween = (int)ChronoUnit.DAYS.between(endDate, startDate);
       return daysBetween;

    }}




























































