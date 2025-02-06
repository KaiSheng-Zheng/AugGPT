import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalendar {
    private int capacity;

    private int currentSize;

    private SortedMap<MyDate, SortedSet<String>> events;


    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.events = new TreeMap<>();
    }


    public boolean addEvent(MyDate date, String event) {
        if (this.currentSize == this.capacity) {
            return false;
        }

        if (this.events.containsKey(date)) {
            SortedSet<String> set = this.events.get(date);
            set.add(event);
        } else {
            SortedSet<String> set = new TreeSet<>();
            set.add(event);
            this.events.put(date, set);
        }
        this.currentSize++;
        return true;
    }


    public String finishNextEvent() {

        if (currentSize == 0) {
            return "NONE";
        }

        SortedSet<String> set = this.events.get(this.events.firstKey());
        String result = set.first();
        set.remove(result);
        if (set.isEmpty()) {
            this.events.remove(this.events.firstKey());
        }
        this.currentSize--;
        return result;
    }
}