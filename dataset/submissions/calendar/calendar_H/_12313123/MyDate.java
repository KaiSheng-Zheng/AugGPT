import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private LocalDate date;
    private ArrayList<String> eventToday=new ArrayList<String>();

    private static ArrayList<MyDate> alldate = new ArrayList<MyDate>();
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        date =LocalDate.of(year,month,day);
        alldate.add(this);
        Collections.sort(alldate, Comparator.comparing(MyDate::getDate));
    }
    public void addDays(int days){
        date=date.plusDays(days);
        year=date.getYear();
        month= date.getMonthValue();
        day=date.getDayOfMonth();
        Collections.sort(alldate, Comparator.comparing(MyDate::getDate));
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }

    public LocalDate getDate() {
        return date;
    }

    public void addEvent(String event){
        eventToday.add(event);
        Collections.sort(eventToday);
    }

    public ArrayList<String> getEventToday() {
        return eventToday;
    }



    public void deleteDone(int i) {
        eventToday.remove(i);
        Collections.sort(eventToday);

    }

    public static ArrayList<MyDate> getAlldate() {
        return alldate;
    }

    public static int difference(MyDate date1, MyDate date2){
        int gap=(int)ChronoUnit.DAYS.between(date1.getDate(),date2.getDate());
        gap=-gap;
        return gap;
    }
    public static void clear(){
        for(MyDate date:alldate){
            date.eventToday.clear();
        }
    }






}
