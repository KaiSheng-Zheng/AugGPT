import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;
    LocalDate localDate;
    public MyDate(int year, int month, int day){
        localDate = LocalDate.of(year,month,day);
    }


    public void addDays(int days){
        localDate=localDate.plusDays(days);
    }
    public String toString(){
        return localDate.toString();
    }
    public static int difference(MyDate date1, MyDate date2){
        return (int)date2.localDate.until(date1.localDate, ChronoUnit.DAYS);
    }
    public boolean isBefore(LocalDate localDate3){
        return localDate.isBefore(localDate3);
    }
    public boolean isEqual(LocalDate localDate3){
        return localDate.isEqual(localDate3);
    }
}
