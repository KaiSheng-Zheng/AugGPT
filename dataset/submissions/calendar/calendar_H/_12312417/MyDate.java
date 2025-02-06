import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class MyDate {
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public void addDays(int days){
        Calendar cal = Calendar.getInstance();
        cal.set(this.year,this.month-1,this.day);
        cal.add(Calendar.DAY_OF_MONTH, days);
        this.year=cal.get(Calendar.YEAR);
        this.month=cal.get(Calendar.MONTH)+1;
        this.day=cal.get(Calendar.DAY_OF_MONTH);
    }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        LocalDate da1= LocalDate.of(date1.year, date1.month,date1.day);
        LocalDate da2= LocalDate.of(date2.year, date2.month,date2.day);
        long daysBetween = ChronoUnit.DAYS.between(da2, da1);
        int daysBetween1 = (int) daysBetween;
        return daysBetween1;
    }
}
