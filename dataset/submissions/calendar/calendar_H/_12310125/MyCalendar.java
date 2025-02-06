import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private final int capacity;
    private ArrayList<String> events = new ArrayList<>();
    private ArrayList<MyDate> dates = new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            events.add(eventName);
            dates.add(date);
            for (int k = 0; k < dates.size(); k++) {
                for (int i = 0; i < dates.size() - 1; i++) {
                    MyDate a = dates.get(i);
                    String b = events.get(i);
                    if (MyDate.difference(dates.get(i), dates.get(i + 1)) > 0) {
                        dates.set(i, dates.get(i + 1));
                        events.set(i, events.get(i + 1));
                        dates.set(i + 1, a);
                        events.set(i + 1, b);
                    } else if (MyDate.difference(dates.get(i), dates.get(i + 1)) == 0
                            && events.get(i).compareTo(events.get(i + 1)) > 0) {
                        dates.set(i, dates.get(i + 1));
                        events.set(i, events.get(i + 1));
                        dates.set(i + 1, a);
                        events.set(i + 1, b);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        String a;
        if (events.isEmpty()) {
            return "NONE";
        } else {
            a = events.get(0);
            dates.remove(0);
            events.remove(0);
        }
        return a;

    }
}
