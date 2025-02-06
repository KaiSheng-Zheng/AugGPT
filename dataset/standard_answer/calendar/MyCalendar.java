import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {
    private static int capacity;
    private static List<String> event;
    public MyCalendar(int capacity) {
        MyCalendar.capacity = capacity;
        event = new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName) {
        if(event.size() == capacity) return false;
        event.add(String.format(date.toString() + eventName));
        event.sort(Comparator.naturalOrder());
        return true;
    }
    public String finishNextEvent() {
        if(event.size() == 0) return "NONE";
        String eventName = event.get(0).substring(10);
        event.remove(0);
        return eventName;
    }
}
