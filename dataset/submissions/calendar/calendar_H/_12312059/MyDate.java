import java.util.Date;
import java.util.Calendar;
public class MyDate {
    private int year;
    private int month;
    private int day;
    Calendar c1 = Calendar.getInstance();

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        c1.set(year,month-1,day);
    }
    public void addDays(int days){
        c1.add(Calendar.DATE, days);
        this.year = c1.get(Calendar.YEAR);
        this.month = c1.get(Calendar.MONTH)+1;
        this.day = c1.get(Calendar.DATE);
    }
    public String toString(){
        if (month<10 && day<10){
            return year+"-0"+month+"-0"+day;
        }
        else if (month<10){
            return year+"-0"+month+"-"+day;
        }
        else if (day<10){
            return year+"-"+month+"-0"+day;
        }
        else {
            return year+"-"+month+"-"+day;
        }
    }
    public static int difference(MyDate date1, MyDate date2){
        Long Date1= date1.c1.getTimeInMillis();
        Long Date2= date2.c1.getTimeInMillis();
        return (int)((Date1-Date2)/24/60/60/1000);
    }
}
