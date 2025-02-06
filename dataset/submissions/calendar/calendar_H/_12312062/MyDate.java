import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }



    public void addDays(int days)  {
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date star = null;
        try {
            star = dft.parse(String.format("%04d-%02d-%02d", this.year, this.month, this.day));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(star);
        rightNow.add(Calendar.DAY_OF_YEAR, days);
        Date end = rightNow.getTime();
        this.year = end.getYear() + 1900;
        this.month = end.getMonth() + 1;
        this.day = end.getDate();
      /*  System.out.println(end);
        System.out.println(year+" "+month+" "+day);*/
    }


    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date star = null;
        try {
            star = dft.parse(date1.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date endDay = null;
        try {
            endDay = dft.parse(date2.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Long starTime = star.getTime();
        Long endTime = endDay.getTime();
        Long num = starTime-endTime;


        return (int) (num / 24 / 60 / 60 / 1000);
    }

}
