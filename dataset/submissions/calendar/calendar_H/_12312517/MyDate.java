public class MyDate {
    private int year;
    private int month;
    private int day;

    public int validdays(int month) {
        boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
        boolean b = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
        if (month == 2) {
            if (b)
                return (28);
            else
                return (29);
        } else {
            if (b)
                return (31);
            else
                return (30);
        }
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        if (this.day + days > validdays(this.month)) {
            int n = this.day + days;
            while (n > validdays(this.month)) {
                n -= validdays(this.month);
                this.month++;
                if (this.month == 13) {
                    this.month = 1;
                    this.year++;
                }
                this.day = n;
            }
        } else {
            this.day += days;
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days = 0;
        if (date1.year < date2.year) {
            for (int i = date1.year; i < date2.year; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    days += 366;
                } else {
                    days += 365;
                }
            }
        }
        int starday = days(date1.year, date1.month, date1.day);
        int endday = days(date2.year, date2.month, date2.day);
        days = starday - endday;
        return days;
    }

    public static int days(int year, int month, int day) {
        int days = 0;
        int[] monthday = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthday1 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean flag;
        flag = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        for (int i = 0; i < month; i++) {
            if (flag) {
                days += monthday1[i];
            } else {
                days += monthday[i];
            }
        }
        days += day;
        return days;
    }
}
