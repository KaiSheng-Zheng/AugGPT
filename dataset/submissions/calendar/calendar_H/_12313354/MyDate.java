public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    public int compareTo(MyDate other) {
        if (year != other.year) {
            return Integer.compare(year, other.year);
        }
        if (month != other.month) {
            return Integer.compare(month, other.month);
        }
        return Integer.compare(day, other.day);
    }

    public void addDays(int days) {
        int totalDays = getTotalDays() + days;
        setTotalDays(totalDays);
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int totalDays1 = date1.getTotalDays();
        int totalDays2 = date2.getTotalDays();
        return totalDays1 - totalDays2;
    }

    private int getTotalDays() {
        int totalDays = 0;
        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            totalDays += getDaysInMonth(i, year);
        }
        totalDays += day;
        return totalDays;
    }

    private void setTotalDays(int totalDays) {
        int remainingDays = totalDays;
        int i = 1;
        while (remainingDays > 0) {
            int daysInYear = isLeapYear(i) ? 366 : 365;
            if (remainingDays <= daysInYear) {
                year = i;
                break;
            }
            remainingDays -= daysInYear;
            i++;
        }
        int remainingMonths = remainingDays;
        i = 1;
        while (remainingMonths > 0) {
            int daysInMonth = getDaysInMonth(i, year);
            if (remainingMonths <= daysInMonth) {
                month = i;
                break;
            }
            remainingMonths -= daysInMonth;
            i++;
        }
        day = remainingMonths;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }
}
