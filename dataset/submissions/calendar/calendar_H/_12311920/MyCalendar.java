import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    private int occupied_capacity = 0;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<MyEvent>(capacity);
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (occupied_capacity < capacity) {
            events.add(new MyEvent(date, eventName));
            occupied_capacity++;
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if (events.size() == 0){
            return "NONE";
        }
        for (int n = 1; n <= events.size(); n++){
            for(int i1 = 0; i1< events.size() - n; i1++){
                int i2 = i1 + 1;
                MyEvent e1 = events.get(i1);
                MyEvent e2 = events.get(i2);
                if (e1.date_number > e2.date_number){
                    events.set(i1 , e2);
                    events.set(i2 , e1);
                }
                if (e1.date_number == e2.date_number && e1.eventName.compareTo(e2.eventName) > 0){
                    events.set(i1 , e2);
                    events.set(i2 , e1);
                }
            }

        }
        occupied_capacity--;
        String name = events.get(0).eventName;
        events.remove(0);
        return name;

    }
}



class MyEvent{
    int date_number;
    MyDate date;
    String eventName;

    MyEvent(MyDate date, String eventName){
        this.date = date;
        this.eventName = eventName;
        this.date_number = date.GetDateNumber();
    }

    public  int get(){
        return 0;
    }
}
