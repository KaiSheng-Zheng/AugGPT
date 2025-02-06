

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {

    public String getDate() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return sdf1.format(date);
    }

    private Date date;
    public MyDate(int year, int month, int day) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateformat.parse(year + "-" + month + "-" + day);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public void addDays(int days) {
        long time = date.getTime();
        long mid = (long) days * 24 * 60 * 60 * 1000;
        time += mid;
        date=new Date(time);

    }

    public String toString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        return dateformat.format(date);
    }
    public static int difference(MyDate date1, MyDate date2){
            Long start=date1.date.getTime();
            Long end=date2.date.getTime();
            Long num=end-start;
            return Math.toIntExact(-num / 24 / 60 / 60 / 1000);
    }
}
