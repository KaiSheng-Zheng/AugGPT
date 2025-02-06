public class MyCalendar {
    private final int capacity;
    public String[] event;
    public MyDate[] date;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        event = new String[capacity];
        date = new MyDate[capacity];
        nextEvent = event[0];
    }
    private int n = 0;
    public String eventName;
    public boolean addEvent(MyDate date, String eventName) {
        n += 1;
        if (n > capacity) {
            return false;
        }
        else {
            this.eventName = eventName;
            this.event[n-1] = eventName;
            this.date[n-1] = date;
            return true;
        }
    }
    private String nextEvent;
    private int step;
    public void nextEvent() {
        if (event[1] != null) {
            nextEvent = event[0];
            step = 0;
            MyDate theDate = date[0];
            for (int counter = 1;counter < event.length;counter++) {
                if (MyDate.difference(theDate,date[counter]) > 0) {
                    nextEvent = event[counter];
                    step = counter;
                    theDate = date[counter];
                }
                else if (MyDate.difference(theDate,date[counter]) == 0) {
                    String[] a = nextEvent.split("");
                    String[] b = event[counter].split("");
                    if (a.length <= b.length) {
                        int n = a.length;
                    }
                    else {
                        int n = b.length;
                    }
                    for (int newCounter = 0;newCounter < n;newCounter++) {
                        if (a[newCounter].compareTo(b[newCounter]) > 0) {
                            nextEvent = event[counter];
                            step = counter;
                            theDate = date[counter];
                            break;
                        }
                        else if (a[newCounter].compareTo(b[newCounter]) < 0) {
                            break;
                        }
                    }
                }
            }
        }
        else if (event[0] != null) {
            nextEvent = event[0];
        }
        else {
            nextEvent = "NONE";
        }
    }
    public void step() {
        for (int counter = 0;counter < capacity;counter++) {
            if (nextEvent.equals(event[counter])) {
                step = counter;
            }
            else {
                step = capacity;
            }
        }
    }
    public String finishNextEvent() {
        nextEvent();
        step();
        return String.format("%s", nextEvent);
    }
    public void finishEvent() {
        if (step < capacity-1) {
            for (int counter = step;counter < capacity-1;counter++) {
                event[counter] = event[counter+1];
            }
            for (int counter = event.length-1;counter >= 0;counter--) {
                if (event[counter] != null) {
                    event[counter] = null;
                    break;
                }
            }
        }
    }
}