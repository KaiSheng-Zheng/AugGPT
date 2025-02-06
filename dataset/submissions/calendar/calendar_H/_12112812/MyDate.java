import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyDate {
    private  int year;
    private int month;
    private int day;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getListS() {
        return listS;
    }

    public void setListS(int listS) {
        this.listS = listS;
    }

    public int[] getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int[] monthDay) {
        this.monthDay = monthDay;
    }
    private int rDays=366;
    private int pDays=365;
    private int listS=0;
    private List<String> listEvent=new ArrayList<>();
    private int [] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
    public List<String> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<String> listEvent) {
        this.listEvent = listEvent;
    }

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    @Override
    public String toString() {
        if (0<month&&month<10)
        {
            if (day<10&&day>0)
            {
                return year+"-"+"0"+month+"-"+"0"+day;
            }
            else
            {
                return year+"-"+"0"+month+"-"+day;
            }
        }
        else
        {
            if (day<10&&day>0)
            {
                return year+"-"+month+"-"+"0"+day;
            }
            else
            {
                return year+"-"+month+"-"+day;
            }
        }

    }
    public void addDays(int days)
    {
        int sumDay=day+days;
        for (int i=1;i<=days;i++)
        {
            if ((year%4==0&&year%100!=0)||year%400==0) {
                monthDay[1] = 29;
            }
            else
            {
                monthDay[1]=28;
            }
            day++;
            if (day>monthDay[month-1])
            {
                day=day-monthDay[month-1];
                month=month+1;
                if (month>12)
                {
                    month=month-12;
                    year=year+1;
                }
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2)
    {
         int Rdays=366;
         int Pdays=365;
         int sum=0;
         int sumDate1=0;
         int sumDate2=0;
            if ((date1.year % 4 == 0 && date1.year % 100 != 0) || (date1.year % 400 == 0)) {
                date1.monthDay[1] = 29;
            } else {
                date1.monthDay[1] = 28;
            }
            if ((date2.year % 4 == 0 && date2.year % 100 != 0) || (date2.year % 400 == 0)) {
                date2.monthDay[1] = 29;
            } else {
                date2.monthDay[1] = 28;
            }
            for (int y=1;y<date1.year;y++) {
                if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0))
                {
                    sumDate1=sumDate1+Rdays;
                }
                else
                {
                    sumDate1=sumDate1+Pdays;
                }
            }
            for (int m=0;m<date1.month-1;m++)
            {
                sumDate1=sumDate1+date1.monthDay[m];
            }
            for (int y=1;y<date2.year;y++) {
                if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0))
                {
                    sumDate2=sumDate2+Rdays;
                }
                else
                {
                    sumDate2=sumDate2+Pdays;
                }
            }
            for (int m=0;m<date2.month-1;m++)
            {
                sumDate2=sumDate2+date2.monthDay[m];
            }
            int all=sumDate1+date1.day-sumDate2-date2.day;
            return all;
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
