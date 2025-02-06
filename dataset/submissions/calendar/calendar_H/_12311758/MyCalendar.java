import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendar {
    private MyDate date;
    private String eventName;
    private int counter;
    private int counter1 = 0;
    private List<MyCalendar> eventlist = new ArrayList<>();
    private int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public MyCalendar(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    public int getCounter1() {
        return this.counter1;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }


    public boolean addEvent(MyDate date, String eventName) {
        if (counter < capacity) {
            MyCalendar event = new MyCalendar(date, eventName);
            eventlist.add(event);
                rePosition(eventlist);
            counter++;
            return true;
        } else {
            return false;

        }
    }

    public List<MyCalendar> rePosition(List<MyCalendar> eventlist) {
        int acounter = counter-1;
        while (acounter>= 0) {
            for (int i = 0; i <=acounter; i++) {
                if (MyDate.difference(eventlist.get(i).date, eventlist.get(i + 1).date) > 0) {
                    Collections.swap(eventlist, i, i + 1);
                } else if (MyDate.difference(eventlist.get(i).date, eventlist.get(i + 1).date) < 0) {
                } else {
                    if (eventlist.get(i).eventName.compareTo(eventlist.get(i + 1).eventName) > 0) {
                        Collections.swap(eventlist, i, i + 1);
                    }
                }

            }
            acounter--;
        }
        return eventlist;
    }


    public String finishNextEvent() {
        if (counter1 < counter) {
            String nextEvent = eventlist.get(counter1).eventName;
            counter1++;
            return nextEvent;
        } else {
            return "NONE";

        }


    }
}
