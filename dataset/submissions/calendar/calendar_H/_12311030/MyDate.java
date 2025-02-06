import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;
    int arr[]={31,28,31,30,31,30,31,31,30,31,30,31};
    int brr[]={31,29,31,30,31,30,31,31,30,31,30,31};

    public MyDate(){

    }
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }public int getYear(){
        return year;
    }public void setYear(int year){
        this.year=year;
    }

    public int getMonth() {
        return month;
    }public void setMonth(int month){
        this.month=month;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day){
        this.day=day;
    }
    public void addDays(int days){
        LocalDate date=LocalDate.of(year,month,day);

        date=date.plusDays(days);
        year=date.getYear();
        month=date.getMonthValue();
        day=date.getDayOfMonth();


    }public String toString(){
        LocalDate date=LocalDate.of(year,month,day);

        return date.toString();

    }

    public static int difference(MyDate date1,MyDate date2){
        LocalDate beginDate=LocalDate.of(date1.year,date1.month,date1.day);
        LocalDate endDate=LocalDate.of(date2.year,date2.month,date2.day);
        long betweenDays= ChronoUnit.DAYS.between(endDate,beginDate);
        int diff=Math.toIntExact(betweenDays);
        return diff;
    }
    private static boolean isLeapYear(int year){
        if((year%4==0&&year%100!=0)||(year%400==0)){
            return true;

        }else{
            return false;
        }

    }
}
