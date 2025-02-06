import java.time.LocalDate;
import java.util.*;
public class MyCalendar {
    private int capacity;
    Map<LocalDate, List<String>> dateevent;


    public static int counter = 0;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        dateevent = new TreeMap<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        
        if (counter < capacity) {
            LocalDate trans = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());

            dateevent.computeIfAbsent(trans, k -> new ArrayList<>()).add(eventName);

            dateevent.get(trans).sort(Comparator.naturalOrder());
         counter += 1;
            return true;
        }
            return false;


    }
        public String finishNextEvent () {
            for (List<String> events : dateevent.values()) {
                if (!events.isEmpty()) {
                    String nextEvent = events.get(0);
                    events.remove(0);
                    counter-=1;
            if(counter<0)counter=0;
                    return nextEvent;
                }
            }
            return "NONE";
        }
    }



