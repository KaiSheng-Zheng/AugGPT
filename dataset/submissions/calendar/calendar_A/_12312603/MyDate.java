import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] dayslist = new int[12];
    private static int[] a = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static int[] b = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public MyDate(int y, int m, int d) {
        year = ((y > 0) ? y : 0);
        month = ((m > 0 && m <= 12) ? m : 0);
        int[] source = {};
        if (year == 0 || month == 0) {
            day = 0;
        } else if (year % 4 == 0 && year % 100 != 0) {
            source = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        } else {
            source = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        }
        dayslist = source.clone();
        if (year == 0 || month == 0) {
            day = 0;
        } else {
            day = ((d > 0 && d <= dayslist[month - 1]) ? d : 0);
        }
    }

    public void addDays(int days) {
        day = day + days;
        while (day > dayslist[month - 1]) {
            day -= dayslist[month - 1];
            month++;
            if (month > 12) {
                month -= 12;
                year++;
            }
        }
    }

    public int[] getDayslist() {
        return dayslist;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        String ny = String.valueOf(year);
        String nm = String.valueOf(month);
        String nd = String.valueOf(day);
        StringBuilder sby = new StringBuilder(ny);
        for (int i = ny.length(); i < 4; i++) {
            sby.insert(0, "0");
        }
        ny = sby.toString();
        StringBuilder sbm = new StringBuilder(nm);
        for (int i = nm.length(); i < 2; i++) {
            sbm.insert(0, "0");
        }
        nm = sbm.toString();
        StringBuilder sbd = new StringBuilder(nd);
        for (int i = nd.length(); i < 2; i++) {
            sbd.insert(0, "0");
        }
        nd = sbd.toString();
        return String.format("%s-%s-%s", ny, nm, nd);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int sum1 = caculate3(date1);
        int sum2 = caculate3(date2);
        int mi = sum1 - sum2;
        return mi;
    }

    public static int caculate3(MyDate date) {
        int y = date.getYear();
        int m = date.getMonth();
        int d = date.getDay();
        boolean flag = (y % 4 == 0 && y % 100 != 0 || y % 400 == 0);
        int sumDay = 0;
        for (int i = 1; i < y; i++) {

            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                sumDay = sumDay + 366;

            } else {
                sumDay = sumDay + 365;
            }
        }
        if (flag == true) {
            for (int i = 0; i < m - 1; i++) {
                sumDay = sumDay + a[i];
            }
        } else {
            for (int i = 0; i < m - 1; i++) {
                sumDay = sumDay + b[i];
            }
        }
        sumDay = sumDay + d - 1;
        return sumDay;
    }
}
