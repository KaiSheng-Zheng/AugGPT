public class MyCalendar {
    public static int event = 0;
     int capacity;
     String eventName;
    public MyCalendar(int capacity){
    this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        event = event + 1;
        this.eventName = eventName;
        if (event>capacity){
            return false;
        }else {return true;}
    }
    public String finishNextEvent(){
        event = event - 1;
        return eventName;
    }
}