import java.util.*;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] a = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        if (this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0)) {
            this.a[2] = 29;
        } else {
            this.a[2] = 28;
        }
        while (days > 0) {
            if (days + this.day > this.a[this.month]) {
                days = days - (this.a[this.month] - this.day + 1);
                this.month++;
                this.day = 1;
            } else {
                this.day = this.day + days;
                days = 0;
                continue;
            }
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            } else {
                continue;
            }
            if (this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0)) {
                this.a[2] = 29;
            } else {
                this.a[2] = 28;
            }
        }
    }

    public String toString() {
        if (this.month < 10 && this.day < 10)
            return String.format("%d-0%d-0%d", this.year, this.month, this.day);
        if (this.month < 10) return String.format("%d-0%d-%d", this.year, this.month, this.day);
        if (this.day < 10) return String.format("%d-%d-0%d", this.year, this.month, this.day);
        return String.format("%d-%d-%d", this.year, this.month, this.day);
    }

    public static int difference(MyDate date1, MyDate date2) {

        int fh = -1;
        int ans = 0;
        int y, m, d;
        int yy, mm, dd;
        int[] a = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (date1.year*10000+date1.month*100+date1.day>date2.year*10000+date2.month*100+date2.day) {
            fh = 1;
            yy = date1.year;
            mm = date1.month;
            dd = date1.day;
            y = date2.year;
            m = date2.month;
            d = date2.day;
        } else {
            yy = date2.year;
            mm = date2.month;
            dd = date2.day;
            y = date1.year;
            m = date1.month;
            d = date1.day;
        }
        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
            a[2] = 29;
        } else {
            a[2] = 28;
        }
        while (true) {
            if (y == yy && m == mm) {
                ans = ans + dd - d;
                break;
            }
            ans = ans + a[m] - d;
            d = 0;
            m++;
            if (m > 12) {
                m = 1;
                y++;
            } else continue;
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                a[2] = 29;
            } else {
                a[2] = 28;
            }
        }
        return ans * fh;
    }
}
