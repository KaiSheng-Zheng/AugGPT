import java.util.Date;
import java.util.Objects;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] table;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        table = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 100 != 0 ? year % 4 == 0 : year % 400 == 0)
            table[2] = 29;
        else
            table[2] = 28;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            if (++day == table[month] + 1) {
                day = 1;
                if (++month == 12 + 1) {
                    month = 1;
                    ++year;
                    if (year % 100 != 0 ? year % 4 == 0 : year % 400 == 0)
                        table[2] = 29;
                    else
                        table[2] = 28;
                }
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        boolean negative = true;
        if (date1.toString().compareTo(date2.toString()) > 0) {
            negative = false;
            MyDate temp = date1;
            date1 = date2;
            date2 = temp;
        }
        MyDate date = new MyDate(date1.year, date1.month, date1.day);
        int count = 0;
        while (!date.equals(date2)) {
            date.addDays(1);
            ++count;
        }
        if (negative)
            count = -count;
        return count;
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

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public boolean equals(MyDate date) {
        return getYear() == date.getYear() && getMonth() == date.getMonth() && getDay() == date.getDay();
    }
}
