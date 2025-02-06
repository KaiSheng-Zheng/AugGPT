import java.util.ArrayList;
import java.util.List;
public class MyCalendar{
    int capacity;
    public static int count;
    public MyCalendar(int capacity){
        this.capacity = capacity;
        count = 0;
    }
    public boolean addEvent(MyDate date, String eventName){
        if (count < capacity){
            new Event(date,eventName);
            count++;
            return true;
        }else {
            return false;
        }
    }
    public static String finishNextEvent(){
        String R = Event.getEvent();
        count--;
        return R;
    }
    class Event{
        String eventName;
        MyDate date;
        public static List<Event> myEventList = new ArrayList<>();
        public Event(MyDate date,String eventName){
            this.date = date;
            this.eventName = eventName;
            myEventList.add(this);
        }
        public static String getEvent(){
            String R;
            int inc = 0;
            int min = 0;
            if (myEventList.isEmpty()){
                R = "NONE";
                return R;
            }
            R = myEventList.get(0).eventName;
            for (Event event : myEventList){
                if (inc == 0){
                    min = MyDate.difference(event.date,new MyDate(0000,00,00));
                    inc = 1;
                }
                if (min > MyDate.difference(event.date,new MyDate(0000,00,00))){
                    min = MyDate.difference(event.date,new MyDate(0000,00,00));
                    R = event.eventName;
                }
            }
            for (Event event : myEventList){
                if (min == MyDate.difference(event.date,new MyDate(0000,00,00))){
                    if (event.eventName.compareTo(R) < 0){
                        R = event.eventName;
                    }
                }
            }
            int c = 0;
            for (Event event : myEventList){
                if (R.equals(event.eventName)){
                    myEventList.remove(c);
                    break;
                }
                c++;
            }
            return R;
        }
    }
}