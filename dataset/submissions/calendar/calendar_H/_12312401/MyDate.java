import java.util.*;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            incrementDay();
        }
    }

    private void incrementDay() {
        int daysInMonth = getDaysInMonth(year, month);
        if (day < daysInMonth) {
            day++;
        } else {
            day = 1;
            incrementMonth();
        }
    }

    private void incrementMonth() {
        if (month < 12) {
            month++;
        } else {
            month = 1;
            year++;
        }
    }

    private static int getDaysInMonth(int year, int month) {
        int daysInMonth;
        if (month == 2) {
            if (isLeapYear(year)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        } else {
            daysInMonth = 31;
        }
        return daysInMonth;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days1 = dateToDays(date1);
        int days2 = dateToDays(date2);
        return days1 - days2;
    }

    private static int dateToDays(MyDate date) {
        int year = date.year;
        int month = date.month;
        int day = date.day;

        int days = 365 * year + day;
        for (int i = 1; i < month; i++) {
            days += getDaysInMonth(year, i);
        }
    
        days += (year-1582) / 4 - (year-1582) / 100 + (year-1582) / 400;
        return days;
    }

    public int compareTo(MyDate other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }
}