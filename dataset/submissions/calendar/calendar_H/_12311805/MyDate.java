

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int days) {
        LocalDate primitiveDay = LocalDate.of(year, month, day);
        LocalDate resultDate = primitiveDay.plusDays(days);
        year = resultDate.getYear();
        month = resultDate.getMonthValue();
        day = resultDate.getDayOfMonth();
    }


    public String toString() {
        String a = String.format("%02d", day);
        String b = String.format("%02d", month);
        return year + "-" + b + "-" + a;
    }

    public static int difference(MyDate date1, MyDate date2) {
        int a = 0;
        LocalDate date3 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate date4 = LocalDate.of(date2.year, date2.month, date2.day);
        if (date3.isBefore(date4)) {
            a = (int) -ChronoUnit.DAYS.between(date3, date4);
        } else if (date3.isAfter(date4)) {
            a = (int) -ChronoUnit.DAYS.between(date3, date4);
        }
        return a;
    }
    public int compareTo(MyDate otherDate) {
        if (year != otherDate.year) {
            return Integer.compare(year, otherDate.year);
        }
        if (month != otherDate.month) {
            return Integer.compare(month, otherDate.month);
        }
        return Integer.compare(day, otherDate.day);
    }
}
