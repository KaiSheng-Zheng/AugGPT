
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void addDays(int days){
        this.day += days;
        while (this.day > getDaysOfTheYearAndMonth(this.year, this.month)) {
            this.day -= getDaysOfTheYearAndMonth(this.year, this.month);
            this.month++;
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
    }

    public int getDaysOfTheYearAndMonth(int year, int month){
        int days = 0;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0) {
                days += 29;
            } else {
                days += 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days += 30;
        } else {
            days += 31;
        }
        return days;
    }
    //Return the difference (number of days) between date1 and date2.
    //In particular, if date1 is earlier than date2, the return value should be <0; Otherwise the return value should be >= 0
    public static int difference(MyDate date1, MyDate date2) {
        long diff = 0;
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date star = dft.parse(date2.toString());
            Date endDay=dft.parse(date1.toString());
            Long starTime=star.getTime();
            Long endTime=endDay.getTime();
            long num=endTime-starTime;
            diff = num/24/60/60/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int diffInt = (int) diff;
        return diffInt;
    }

    // Return a string of the formatted date (yyyy-mm-dd), like 2023-01-31.
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    @Override
    public int compareTo(MyDate o) {
        return difference(this, o);
    }
}
