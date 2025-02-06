import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            MyEvent event = new MyEvent(date, eventName);
            events.add(event);
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if (this.events.isEmpty()) {
            return "NONE";
        } else {
            for (int i = 0; i < events.size(); i++) {
                for (int j = i + 1; j < events.size(); j++) {
                    int gap = MyDate.difference(events.get(i).getDate(), events.get(j).getDate());
                    if (gap > 0) {
                        events.add(i, events.get(j));
                        events.remove(j + 1);
                    }
                }
            }
            ArrayList<MyEvent> SameDayEvents = new ArrayList<>();
            for (int i = 0; i < events.size(); i++) {
                int gap = MyDate.difference(events.get(0).getDate(), events.get(i).getDate());
                if (gap == 0) {
                    SameDayEvents.add(events.get(i));
                }
            }
            for (int i = 0; i < SameDayEvents.size(); i++) {
                for (int j = i + 1; j < SameDayEvents.size(); j++) {
                    String s1 = SameDayEvents.get(i).getEvent();
                    String s2=SameDayEvents.get(j).getEvent();
                    int result=s1.compareTo(s2);
                    if(result>0){
                        SameDayEvents.add(i,SameDayEvents.get(j));
                        SameDayEvents.remove(j+1);
                    }
                }
            }
            events.remove(SameDayEvents.get(0));
            return SameDayEvents.get(0).getEvent();
        }
    }
}

