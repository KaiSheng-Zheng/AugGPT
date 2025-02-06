import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private String year;
    private String month;
    private String day;

    private long time;
    private Date date;

    public MyDate(int year, int month, int day){
        this.day = ""+day;
        this.month = ""+month;
        this.year = ""+year;
        String str = year+"-"+month+"-"+day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            this.date = sdf.parse(str);
        }catch (ParseException e){}
        this.time = date.getTime();
        String str2 = sdf.format(date);
        this.year = str2.substring(0,4);
        this.month = str2.substring(5,7);
        this.day = str2.substring(8);
    }

    public void addDays(int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,days);
        this.date.setTime(c.getTimeInMillis());
        this.time = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str2 = sdf.format(date);
        this.year = str2.substring(0,4);
        this.month = str2.substring(5,7);
        this.day = str2.substring(8);
    }

    @Override
    public String toString(){
        return year+"-"+month+"-"+day;
    }

    public static int difference(MyDate date1, MyDate date2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1.date);
        c2.setTime(date2.date);
        long t = c1.getTimeInMillis() - c2.getTimeInMillis();
        t = t/1000/3600/24;
        return (int)t;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date = date;
    }
}