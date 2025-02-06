public class MyCalendar {
    private int capacity;
    private Event[] events;
    private int eventCount;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new Event[capacity];
        this.eventCount = 0;
    }
    public boolean addEvent(MyDate date, String eventName){
        if (eventCount < capacity){
            Event newEvent = new Event(date, eventName);
            events[eventCount] = newEvent;
            eventCount++;
            return true;
        }
        else return false;
    }
    public String finishNextEvent(){
        if (eventCount == 0){
            return "NONE";
        }
        int n = 0;
        for (int i = 0; i < eventCount; i++){
            int differnce = MyDate.difference(events[i].date, events[n].date);
            if (differnce < 0 || (differnce == 0 && events[i].eventName.compareTo(events[n].eventName) < 0)){
                n = i;
            }
        }
        String Eventtofinish = events[n].eventName;
        for (int i = n; i < eventCount - 1; i++){
            events[i] = events[i + 1];
        }
        eventCount--;
        return Eventtofinish;
    }
}
class Event{
    MyDate date =new MyDate();
    String eventName = new String();
    public Event(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }
    public Event(){
    }
}
