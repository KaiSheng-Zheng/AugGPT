import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class MyCalendar {
    public int capacity;

    public ArrayList<String> event;
    public ArrayList<MyDate> date;
    public ArrayList<ArrayList<String>> DayEvent;

    public MyCalendar(int capacity) {

        this.capacity = capacity;
        this.event = new ArrayList<>();
        this.date = new ArrayList<>();
        this.DayEvent = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (this.event.size() < this.capacity) {
            if (!this.date.isEmpty()) {
                for (MyDate e :
                        this.date) {
                    if (Objects.equals(e.toString(), date.toString())) {
                        DayEvent.get(this.date.indexOf(date)).add(eventName);
                        DayEvent.get(this.date.indexOf(date)).sort(Comparator.comparing(String::toString));
                        this.event.add(eventName);
                        return true;
                    }
                }
                this.date.add(date);
                ArrayList<String> Event = new ArrayList<>();
                Event.add(eventName);
                Event.sort(Comparator.comparing(String::toString));
                this.DayEvent.add(Event);
            } else {
                ArrayList<String> Event = new ArrayList<>();
                Event.add(eventName);
                Event.sort(Comparator.comparing(String::toString));
                this.date.add(date);
                this.DayEvent.add(Event);
            }
            this.event.add(eventName);
            return true;
        } else return false;
    }


    public String finishNextEvent() {
        if (event.isEmpty()) {
            return "NONE";
        } else {
            int m = 0;
            int c = 0;
            for (MyDate e :
                    this.date) {
                int counter = 0;
                for (MyDate o :
                        this.date) {
                    counter += MyDate.difference(e, o);
                }
                if (c > counter) {
                    c = counter;
                    m = this.date.indexOf(e);
                }
            }
            String r = DayEvent.get(m).get(0);
            DayEvent.get(m).remove(0);
            event.remove(0);
            if (DayEvent.get(m).isEmpty()) {
                DayEvent.remove(m);
                date.remove(m);
            }
            return r;
        }
    }
}
