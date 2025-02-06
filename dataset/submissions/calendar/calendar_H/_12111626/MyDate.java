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
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysInMonthLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] daysInMonthTemp = daysInMonth;
        if (isLeapYear()) {
            daysInMonthTemp = daysInMonthLeap;
        }
        int temp = day + days;
        while (temp > daysInMonthTemp[month-1]) {
            temp -= daysInMonthTemp[month-1];
            month++;
            if (month > 12) {
                month = 1;
                year++;
                if (isLeapYear()) {
                    daysInMonthTemp = daysInMonthLeap;
                } else {
                    daysInMonthTemp = daysInMonth;
                }
            }
        }
        day = temp;
    }

    private boolean isLeapYear() {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            } else {
                return year % 400 == 0;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysInMonthLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] daysInMonthTemp = daysInMonth;
        if (date1.isLeapYear()) {
            daysInMonthTemp = daysInMonthLeap;
        }
        int days1 = date1.day;
        for (int i = 0; i < date1.month-1; i++) {
            days1 += daysInMonthTemp[i];
        }
        for (int i = 0; i < date1.year; i++) {
            if (i % 4 == 0) {
                if (i % 100 != 0) {
                    days1 += 366;
                } else {
                    if (i % 400 == 0) {
                        days1 += 366;
                    } else {
                        days1 += 365;
                    }
                }
            } else {
                days1 += 365;
            }
        }
        if (date2.isLeapYear()) {
            daysInMonthTemp = daysInMonthLeap;
        } else {
            daysInMonthTemp = daysInMonth;
        }
        int days2 = date2.day;
        for (int i = 0; i < date2.month-1; i++) {
            days2 += daysInMonthTemp[i];
        }
        for (int i = 0; i < date2.year; i++) {
            if (i % 4 == 0) {
                if (i % 100 != 0) {
                    days2 += 366;
                } else {
                    if (i % 400 == 0) {
                        days2 += 366;
                    } else {
                        days2 += 365;
                    }
                }
            } else {
                days2 += 365;
            }
        }
        return days1 - days2;
    }
}