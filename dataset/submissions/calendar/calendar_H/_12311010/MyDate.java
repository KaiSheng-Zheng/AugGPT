import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;






public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;



    public int compareTo(MyDate other){
        return this.ToLocalDate().compareTo(other.ToLocalDate());
    }


    ArrayList<String> EventsOfTheDay = new ArrayList<String>();




    public LocalDate ToLocalDate(){
        return LocalDate.of(year,month,day);
    }




    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate () {}



    public void addDays(int days){
    LocalDate newday =LocalDate.of(year,month,day).plusDays(days);
    this.year = newday.getYear();
    this.month = newday.getMonthValue();
    this.day = newday.getDayOfMonth();


    }

    public String toString(){
        return year+"-"+String.format("%02d", month)+"-"+String.format("%02d", day);
    }

    public static int difference(MyDate date1, MyDate date2){
        LocalDate start = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate end = LocalDate.of(date2.year, date2.month, date2.day);
        long daysdifference = ChronoUnit.DAYS.between(end,start);
        return (int) daysdifference;
    }


}
