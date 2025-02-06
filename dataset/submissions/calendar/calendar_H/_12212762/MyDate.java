import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }

    public int setYear(int year0){
        year=year0;
        return year;
    }
    public int setMonth(int year0){
        month=year0;
        return month;
    }
    public int setDay(int year0){
        day=year0;
        return day;
    }


    public void addDays(int days){
        String Date1=toString();
        Date currdate=new Date();
        try{
            currdate=new SimpleDateFormat("yyyy-MM-dd").parse(Date1);
        }catch(ParseException e){

        }
        Calendar ca=Calendar.getInstance();
        ca.setTime(currdate);
        ca.add(Calendar.DATE,days);
        currdate=ca.getTime();
        SimpleDateFormat Date=new SimpleDateFormat("yyyy-MM-dd");
        String[] B=Date.format(currdate).split("-");
        int a=Integer.parseInt(B[0]);
        setYear(a);
        int b=Integer.parseInt(B[1]);
        setMonth(b);
        int c=Integer.parseInt(B[2]);
        setDay(c);
    }

    public String toString(){
        if(month<10&&day<10) {
            String A = year + "-0" + month + "-0" + day;
            return A;
        }else if(month>10&&day<10) {
            String A = year + "-" + month + "-0" + day;
            return A;
        }else if(month>10&&day>10) {
            String A = year + "-" + month + "-" + day;
            return A;
        }else {
            String A = year + "-0" + month + "-" + day;
            return A;
        }
    }

    public static int difference(MyDate date1,MyDate date2) {
        LocalDate startDate=LocalDate.of(date1.year,date1.month, date1.day);
        LocalDate endDate=LocalDate.of(date2.year,date2.month, date2.day);
        long daysBetween= DateDifferenceCalculator.calculateDaysBetween(startDate,endDate);
        int days=(int)daysBetween;
        return -days;
    }
    class DateDifferenceCalculator{
        public static long calculateDaysBetween(LocalDate date1,LocalDate date2){
            return ChronoUnit.DAYS.between(date1,date2);
        }
    }

}
