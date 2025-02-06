import java.util.*;
import java.util.stream.Collectors;

public class MyCalendar {
    private int capacity;
    private List<String> list = new ArrayList<String>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }


    public boolean addEvent(MyDate date, String eventname) {
        if (list.size() >= capacity) {
            return false;
        }
        list.add(date.toString() + eventname);
        list = list.stream().sorted().collect(Collectors.toList());
        return true;
    }

    public String finishNextEvent() {
        if (list.isEmpty()) {
            return "NONE";
        }
        String str = list.get(0);
        list.remove(0);
        return str.substring(10);
    }

}