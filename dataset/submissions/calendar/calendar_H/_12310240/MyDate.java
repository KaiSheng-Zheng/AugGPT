import java.time.LocalDate;
import java.util.*;

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        LocalDate currentDate = LocalDate.of(year, month, day);
        LocalDate newDate = currentDate.plusDays(days);
        this.year = newDate.getYear();
        this.month = newDate.getMonthValue();
        this.day = newDate.getDayOfMonth();
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days1 = getDaysSinceEpoch(date1.year, date1.month, date1.day);
        int days2 = getDaysSinceEpoch(date2.year, date2.month, date2.day);
        return days1 - days2;
    }

    @Override
    public int compareTo(MyDate other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }

    private static int getDaysInMonth(int year, int month) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year) && month == 2) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getDaysSinceEpoch(int year, int month, int day) {
        int days = 0;
        for (int y = 0; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            days += getDaysInMonth(year, m);
        }
        days += day;
        return days;
    }
}
