import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;
class Pair{
    String s;int number;
    Pair(String s,int number){
        this.s=s;this.number=number;
    }
}
public class MyDate implements Comparable{
    private int year, month, day;
    private LocalDate localDate;
    private TreeMap<String,Integer> events = new TreeMap<>();
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        localDate = LocalDate.of(year, month, day);
    }

    public void addDays(int days) {
        localDate = localDate.plusDays(days);
        this.day = localDate.getDayOfMonth();
        this.month = localDate.getMonthValue();
        this.year = localDate.getYear();
    }

    public String toString() {
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    public static int difference(MyDate date1, MyDate date2) {
        return (int) (date1.localDate.toEpochDay() - date2.localDate.toEpochDay());
    }
    public int compareTo(Object o){
        if(o instanceof MyDate mydate1){
            return (int)(this.localDate.toEpochDay()-mydate1.localDate.toEpochDay());
        }else{
            throw new RuntimeException();
        }
    }
    public void addEvent(String s){
        if(events.containsKey(s)){
            events.replace(s,events.get(s)+1);
        }else{
            events.put(s,1);
        }
    }

    public String pollFirst(){
        String s = events.firstKey();
        if(events.get(s)>1){
            events.replace(s,events.get(s)-1);
        }else{
            events.pollFirstEntry();
        }
        return s;
    }
    public boolean eventsEmpty(){
        return events.isEmpty();
    }
}
