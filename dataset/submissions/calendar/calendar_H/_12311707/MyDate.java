import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private int year,month,day;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public void addDays(int days){
        DateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date=dft.parse(this.toString());
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date);
//            System.out.println(this.toString());
//            System.out.println(calendar.get(Calendar.YEAR));
//            System.out.println(calendar.get(Calendar.MONTH));
//            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
            calendar.add(Calendar.DAY_OF_YEAR,days);
//            System.out.println(calendar.get(Calendar.MONTH));
            this.year=calendar.get(Calendar.YEAR);
            this.month=calendar.get(Calendar.MONTH)+1;
            this.day=calendar.get(Calendar.DAY_OF_MONTH);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    public static int difference(MyDate date1,MyDate date2){
        DateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date d1=dft.parse(date1.toString()),d2=dft.parse(date2.toString());
            return (int)((d1.getTime()-d2.getTime())/24/3600000);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return 0;
    }
}
