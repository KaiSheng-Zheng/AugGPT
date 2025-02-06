
import java.util.ArrayList;
import java.util.Calendar;


public class MyDate {
    Calendar c = Calendar.getInstance();
    int year;
    int month;
    int day;
    ArrayList<String> someEvent = new ArrayList<>();
    int eventCounter = 0;//be need to sort the even in abc

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        c.set(year,month-1,day);
    }


    public void addDays(int days) {
        c.add(Calendar.DATE, days);
        year =c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH)+1;
        day = c.get(Calendar.DATE);
    }

    public String toString() {
        String a;
        if (month < 10 && day < 10) {
            a = year + "-0" + month + "-0" + day;
        } else if (day < 10) {
            a = year + "-" + month + "-0" + day;
        } else if (month < 10) {
            a = year + "-0" + month + "-" + day;
        } else {
            a = year + "-" + month + "-" + day;
        }
        return a;
    }

    public static int difference(MyDate date1, MyDate date2){
        Calendar c = Calendar.getInstance();
        c.set(date1.year,date1.month-1,date1.day);
        long time1 = c.getTimeInMillis();
        c.set(date2.year,date2.month-1,date2.day);
        long time2 = c.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return -(int)(between_days);
    }


}
