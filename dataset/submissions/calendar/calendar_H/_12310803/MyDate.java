import java.time.LocalDate;
import java.util.ArrayList;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static long sum(MyDate d) {
        int day = 0;
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < d.getYear(); i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                day += 366;
            } else {
                day += 365;
            }
        }
        if (d.getYear() % 4 == 0 && d.getYear() % 100 != 0 || d.getYear() % 400 == 0) {
            monthDays[2] = 29;
        }
        for (int i = 1; i < d.getMonth(); i++) {
            day += monthDays[i];
        }
        day += d.getDay();
        return day;
    }

    public static int difference(MyDate date1, MyDate date2) {
        long s1 = sum(date1);
        long s2 = sum(date2);
        return (int)(s1 - s2);
    }

    public void addDays(int days) {
        LocalDate date = LocalDate.of(year, month, day);
        date = date.plusDays(days);
        year = date.getYear();
        month = date.getMonthValue();
        day = date.getDayOfMonth();
        System.out.println("1");
    }

    public String toString() {
        String output = String.format("%02d-%02d-%02d",getYear(),getMonth(),getDay());
        return output;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}