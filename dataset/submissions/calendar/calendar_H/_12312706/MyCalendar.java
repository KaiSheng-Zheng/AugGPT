import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyDate> dateList = new ArrayList<>();
    private ArrayList<String> eventList = new ArrayList<>();
    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName) {
        if (capacity <= 0) return false;
        else {
            int index = Collections.binarySearch(dateList, date);
            if (index < 0) {
                index = -index - 1;
            }
            else {
                while (index < dateList.size() && dateList.get(index).compareTo(date) == 0
                        && eventList.get(index).compareTo(eventName) < 0) {
                    index++;  // "<0" means the event should be placed after the event at "index".
                }
            }
            dateList.add(index, date);  eventList.add(index, eventName); capacity--;
            return true;
        }
    }
    public String finishNextEvent() {
        if (eventList.isEmpty()) return "NONE";
        else {
            String event = eventList.get(0);
            dateList.remove(0); eventList.remove(0);
            capacity++;
            return event;
        }
    }
}
