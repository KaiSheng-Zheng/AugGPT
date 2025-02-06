import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.lang.*;
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public int getMonth()
    {
        return month;
    }
    public void setMonth(int month)
    {
        this.month = month;
    }
    public int getDay()
    {
        return day;
    }
    public void setDay(int day)
    {
        this.day = day;
    }
    public void addDays(int days)
    {
        while(days!=0)
        {
            if(year%4==0 && year%100!=0 && month==2)
            {
                if(day+days>29)
                {
                    month++;
                    days = days-(30-day);
                    day = 1;
                }
                else
                {
                    day = day+days;
                    days = 0;
                }
            }
            else if(month==2)
            {
                if(day+days>28)
                {
                    month++;
                    days = days-(29-day);
                    day = 1;
                }
                else
                {
                    day = day+days;
                    days = 0;
                }
            }
            else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
            {
                if(day+days>31)
                {
                    month++;
                    days = days-(32-day);
                    day = 1;
                    if(month>12)
                    {
                        year++;
                        month = month-12;
                    }
                }
                else
                {
                    day = day+days;
                    days = 0;
                }
            }
            else if(month==4 || month==6 || month==9 || month==11)
            {
                if(day+days>30)
                {
                    month++;
                    days = days-(31-day);
                    day = 1;
                }
                else
                {
                    day = day+days;
                    days = 0;
                }
            }
        }

    }
    public static int difference(MyDate date1, MyDate date2)
    {
        LocalDate datea = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate dateb = LocalDate.of(date2.year, date2.month, date2.day);

        long dayDifference = ChronoUnit.DAYS.between(datea, dateb);
        dayDifference = dayDifference*-1;
        return (int) dayDifference;
    }

    public String toString()
    {
        if(month<10&&day<10)
            return String.format("%s-0%s-0%s", year, month, day);
        else if(month<10)
            return String.format("%s-0%s-%s", year, month, day);
        else if(day<10)
            return String.format("%s-%s-0%s", year, month, day);
        else
            return String.format("%s-%s-%s", year, month, day);
    }

}
