import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.Temporal;
public class MyDate {

    // error: not following assignment requirement
    // missing fields "day", "month", "year"
    LocalDate date;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MyDate(int year, int month, int day){
        date = LocalDate.of(year,month,day);
    }
    public void addDays(int days){
        date = date.plusDays(days);
    }


    public String toString(){
        String formattedDateTime = date.format(formatter);
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }
    public static int difference(MyDate date1, MyDate date2){
        long daysBetween = ChronoUnit.DAYS.between(date2.date,date1.date);
        return (int)daysBetween;
    }
}
