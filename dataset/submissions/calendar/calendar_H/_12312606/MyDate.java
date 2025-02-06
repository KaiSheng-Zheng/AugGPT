public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        int totalDays = dateToDays(this) + days-1;
        MyDate newDate = daysToDate(totalDays);
        this.year = newDate.year;
        this.month = newDate.month;
        this.day = newDate.day;
    }

    private static MyDate daysToDate(int totalDays) {
        int year = 1;
        int month = 1;
        int day = 1;

        while (totalDays > 0) {
            int daysInYear = isLeapYear(year) ? 366 : 365;
            if (totalDays >= daysInYear) {
                totalDays -= daysInYear;
                year++;
            } else {
                int daysInMonth = getDaysInMonth(year, month);
                if (totalDays >= daysInMonth) {
                    totalDays -= daysInMonth;
                    month++;
                } else {
                    day += totalDays;
                    totalDays = 0;
                }
            }
        }

        return new MyDate(year, month, day);
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

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days1 = dateToDays(date1);
        int days2 = dateToDays(date2);
        return days1- days2;
    }

    private static int dateToDays(MyDate date) {
        int year = date.year;
        int month = date.month;
        int day = date.day;

        int totalDays = 0;
        for (int y = 1; y < year; y++) {
            totalDays += 365;
            if (isLeapYear(y)) {
                totalDays++;
            }
        }

        for (int m = 1; m < month; m++) {
            totalDays += date.getDaysInMonth(year, m);
        }

        totalDays += day;
        return totalDays;
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