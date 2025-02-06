import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
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

    static SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void addDays(int days) {
        String date = year + "-" + month + "-" + day;
        Date Date1;
        try {
            Date1 = myDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date1);
        calendar.add(Calendar.DATE, days);
        Date Date2 = calendar.getTime();
        String date2 = myDateFormat.format(Date2);
        year = Integer.parseInt(date2.substring(0, 4));
        month = Integer.parseInt(date2.substring(5, 7));
        day = Integer.parseInt(date2.substring(8));
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        Date Date1;
        try {
            Date1 = myDateFormat.parse(date1.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date Date2;
        try {
            Date2 = myDateFormat.parse(date2.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Long start = Date1.getTime();
        Long end = Date2.getTime();
        long difference1 = start - end;
        return (int) (difference1 / 24 / 60 / 60 / 1000);
    }
}