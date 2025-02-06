import java.util.TreeSet;

public class MyCalendar {
    int capacity;
    int number=0;
    TreeSet<MyDate> calendar = new TreeSet<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(number>=capacity)
            return false;
        if(calendar.contains(date)){
            date.addEvent(eventName);
            number++;
        }else{
            date.addEvent(eventName);
            calendar.add(date);
            number++;
        }
        return true;
    }
    public String finishNextEvent(){
        if(calendar.isEmpty())
            return "NONE";
        String s=calendar.first().pollFirst();
        number--;
        if(calendar.first().eventsEmpty()){
            calendar.pollFirst();
        }
        return s;
    }
}
