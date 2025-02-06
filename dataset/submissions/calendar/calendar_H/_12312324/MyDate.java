import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public int eventamount=0;

    public
    LocalDate localDate;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
        localDate = LocalDate.of(year,month,day);
    }
    public void addDays(int days){
        localDate = localDate.plusDays(days);
    }
    public String toString(){
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }
    public LocalDate getDate(){
        return localDate;
    }
    public static int difference(MyDate date1, MyDate date2){
        return  (int)(date1.getDate().toEpochDay()-date2.getDate().toEpochDay());
    }
}
