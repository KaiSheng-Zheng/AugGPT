import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.SimpleFormatter;

public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static int difference(MyDate date1,MyDate date2)  {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = null;
        try {
            time1 = sf.parse(date1.toString());

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date time2 = null;
        try {
            time2 = sf.parse(date2.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long timeGap=time1.getTime()-time2.getTime();
        return (int)(timeGap/24/60/60/1000);
    }
    public void addDays(int days)  {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = sf.parse(this.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long timee=time.getTime()+(long)(days)*24*60*60*1000;
        Date date=new Date(timee);
        String result = sf.format(date);
        String[] arr=result.split("-");
        this.year=Integer.parseInt(arr[0]);
        this.month=Integer.parseInt(arr[1]);
        this.day=Integer.parseInt(arr[2]);
    }

    @Override
    public String toString() {
        String fmonth = String.valueOf(month);
        String fday=String.valueOf(day);
        if (month<10){
            fmonth="0"+month;
        }if (day<10){fday="0"+day;}
        return year+"-"+fmonth+"-"+fday;
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

    @Override
    public int compareTo(Object o) {
        if (this.toString().compareTo(o.toString())!=0){
            return this.toString().compareTo(o.toString());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

}

