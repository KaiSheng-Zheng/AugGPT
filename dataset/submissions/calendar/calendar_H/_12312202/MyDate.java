public class MyDate {
    private int year;
    private int month;
    private int day;
    public static int[] commonnum = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int[] leapnum = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getYear() {
        return year;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean leap(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) return true;
        return false;
    }

    public void addDays(int days) {
        for (int i = 1; i <= days; i++) {
            if (leap(year)) {
                if (day == leapnum[month]) {
                    if (month == 12) {
                        year++;
                        month = 1;
                        day = 1;
                    } else {
                        month++;
                        day = 1;
                    }
                } else {
                    day++;
                }
            } else {
                if (day == commonnum[month]) {
                    if (month == 12) {
                        year++;
                        month = 1;
                        day = 1;
                    } else {
                        month++;
                        day = 1;
                    }
                } else {
                    day++;
                }
            }
        }
    }
    public String toString() {
        String now = "";
        if (year < 1000) now += "0";
        if (year < 100) now += "0";
        if (year < 10) now += "0";
        now += String.valueOf(year);
        now += "-";
        if (month < 10) now += "0";
        now += String.valueOf(month);
        now += '-';
        if (day < 10) now += "0";
        now += String.valueOf(day);
        return now;
    }
    public int totalDay() {
        int tot = 0;
        for (int i = 0; i < year; i++)
            if (leap(i)) tot += 366;
            else tot += 365;
        for (int i=1;i<month;i++)
            if (leap(year)) tot+=leapnum[i];
            else tot+=commonnum[i];
        tot+=day;
        return tot;
    }
    public static int difference(MyDate date1, MyDate date2) {
        int day1 = date1.totalDay();
        int day2 = date2.totalDay();
        return day1 - day2;
    }
}
