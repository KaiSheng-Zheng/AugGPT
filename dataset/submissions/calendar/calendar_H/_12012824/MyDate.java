import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
public class MyDate {
    private int year;
    private int month;
    private int day;
    private LocalDate localDate;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        localDate = LocalDate.of(year,month,day);
    }
    public void addDays(int days){
        localDate = localDate.plusDays(days);
    }
    public String toString(){
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    public static int difference(MyDate date1, MyDate date2){
        return (int) (date1.localDate.toEpochDay()-date2.localDate.toEpochDay());
    }
}