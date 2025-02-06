import java.util.ArrayList;
import java.util.Collections;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int theYear, int theMonth, int theDay)
    {
        month = checkMonth(theMonth);
        year = theYear;
        day = checkDay(theDay);
    }
    private int checkMonth(int testMonth)
    {
        if (testMonth > 0 && testMonth <= 12)
            return testMonth;
        else
            return 1;
    }
    private int checkDay(int testDay)
    {
        int []a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (testDay > 0 && testDay <= a[month])
            return testDay;
        if (month == 2 && testDay ==29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            return testDay;
        return 1;
    }

    public void addDays(int days)
    {
        int []a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean less = true;
        while(day + days > a[month])
        {
            less = false;
            if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
                a[2] = 29;
            else
                a[2] = 28;
            if (month  > 11){
                if(day + days <= a[month] + a[1]){
                    day += days - a[month];
                    month = 1;
                    year++;
                    break;
                }
                else {
                    days = days - a[month];
                    month = 1;
                    year++;
                }
            }
            else if(day + days <= a[month] + a[month + 1]){
                day += days - a[month];
                month++;
                break;
            }
            else {
                days -= a[month];
                month++;
            }
        }
        if (less)
            day+= days;
    }
    public String toString()
    {
        return String.format("%d-%02d-%02d", year, month, day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        int[] a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (date1.year != date2.year) {
            int add = 0, add1 = 0, add2 = 0;
            for (int i = Math.min(date1.year, date2.year); i < Math.max(date1.year, date2.year); i++) {
                if ((i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)))
                    add += 366;
                else
                    add += 365;
            }
            for (int i = 1; i < date1.month; i++)
            {
                if ((date1.year % 400 == 0 || (date1.year % 4 == 0 && date1.year % 100 != 0)) && i == 2)
                    add1+= 29;
                else 
                    add1+= a[i];
            }
            add1+= date1.day;
            for (int i = 1; i < date2.month; i++)
            {
                if ((date2.year % 400 == 0 || (date2.year % 4 == 0 && date2.year % 100 != 0)) && i == 2)
                    add2+= 29;
                else
                    add2+= a[i];
            }
            add2+= date2.day;
            if (date1.year > date2.year)
            {
                return add + add1 - add2;
            }
            else {
                return -add - add2 + add1;
            }
        } else if (date1.month != date2.month) {
            int add = 0;
            for (int i = Math.min(date1.month, date2.month); i < Math.max(date1.month, date2.month); i++) {
                add += a[i];
            }
            if (date1.month > date2.month)
                return add + date1.day - date2.day;
            else
                return -add - date2.day + date1.day;
        } else if (date1.day != date2.day)
            return date1.day - date2.day;
        else return 0;
    }
}