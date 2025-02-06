import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
        this.newlist = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String name) {
        MyEvent event = new MyEvent(date, name);
        if (events.size() + 1 > this.capacity) {
            return false;
        } else {
            events.add(event);
            return true;
        }

    }

    private MyEvent mindate;
    private MyEvent minname;
    private ArrayList<MyEvent> newlist;

    public String finishNextEvent() {
        if (this.events.isEmpty()) {
            return "NONE";
        } else if (events.size() == 1) {
            minname = events.get(0);
        } else if (events.size() == 2) {
            if (MyDate.difference(events.get(0).getDate(), events.get(1).getDate()) < 0) {
                minname = events.get(0);
            } else if (MyDate.difference(events.get(0).getDate(), events.get(1).getDate()) > 0) {
                minname = events.get(1);
            }else {
                if (events.get(0).getName().compareTo(events.get(1).getName()) < 0) {
                    minname = events.get(0);
                } else minname = events.get(1);
            }
        } else {
            for (int i = 0; i < events.size() - 1; i++) {
                if (MyDate.difference(events.get(i).getDate(), events.get(i + 1).getDate()) < 0) {
                    mindate = events.get(i);
                }
            }
            for (MyEvent event : events) {
                if (event.getDate().equals(mindate.getDate())) {
                    newlist.add(event);
                }
            }
            if (newlist.size() == 1) {
                minname = newlist.get(0);
            } else {
                for (int i = 0; i < newlist.size() - 1; i++) {
                    if (newlist.get(i).getName().compareTo(newlist.get(i + 1).getName()) < 0) {
                        minname = newlist.get(i);
                    } else minname = newlist.get(i + 1);
                }
            }
        }
        events.remove(minname);
        newlist.clear();
        return minname.toString();
    }
}
