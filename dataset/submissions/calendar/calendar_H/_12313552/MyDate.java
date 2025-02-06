import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class MyDate {

    private int year;
    private int month;
    private int day;
    public ArrayList<String> events = new ArrayList<String>();


    public MyDate(int year,int month,int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        ArrayList<String> events = new ArrayList<String>();
    }

    public void addDays(int days){
        LocalDate today = LocalDate.of(this.year,this.month,this.day);
        LocalDate newDay = today.plusDays(days);
        this.year = newDay.getYear();
        this.month = newDay.getMonthValue();
        this.day = newDay.getDayOfMonth();
    }
    public static int difference(MyDate date1,MyDate date2){
        LocalDate today = LocalDate.of(date1.year, date1.month,date1.day);
        LocalDate toDo = LocalDate.of(date2.year, date2.month, date2.day);
        long days = ChronoUnit.DAYS.between(today,toDo);

        return (int) days - (int)days*2;
    }
    public String toString(){
        String Month,Day;
        if(month<10){
            Month = "0"+month;
        }else Month = month+"";
        if(day<10){
            Day = "0"+day;
        }else Day = day+"";

        return String.format("%d-%s-%s",year,Month,Day);
    }

    public boolean judging (int year){
        if (year%4==0 && year%100!=0){
            return true;
        }else if (year%400==0){
            return true;
        }else return false;
    }

}
