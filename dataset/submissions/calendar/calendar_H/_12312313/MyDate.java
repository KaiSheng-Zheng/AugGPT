import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private int  year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
            this.day=day;
            this.month=month;
            this.year=year;
    }

    public void addDays(int days){
        try{
            DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        String DATE=year + "-" + month + "-" + day;
        Calendar cal=Calendar.getInstance();
        Date star=dft.parse(DATE);
        cal.setTime(star);
        cal.add(Calendar.DATE,days);
        this.year=cal.get(Calendar.YEAR);
        this.month=cal.get(Calendar.MONTH)+1;
        this.day=cal.get(Calendar.DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String a="-";
        String b="-";
        if(month<10){
            a="-0";
        }
        if(day<10){
            b="-0";
        }
            String DATE=year + a + month + b + day;
        return DATE;

    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDateTime d1 = LocalDateTime.of(date1.year, date1.month, date1.day,0,0,0);
        LocalDateTime d2 = LocalDateTime.of(date2.year, date2.month, date2.day,0,0,0);
        Duration period=Duration.between(d2,d1);
        int i= (int) period.toDays();
    return i;
    }
}
