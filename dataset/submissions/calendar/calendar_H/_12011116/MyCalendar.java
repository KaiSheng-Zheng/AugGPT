import java.util.PriorityQueue;

public class MyCalendar {

    private int capacity;

    public PriorityQueue<MyDate> data;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.data = new PriorityQueue<>(capacity);
    }

    public boolean addEvent(MyDate date, String eventName) {
        if ( data.size() >= capacity )
            return false;
        MyDate t = new MyDate(date, eventName);
        data.add(t);
        return true;
    }

    public String finishNextEvent() {
        if ( data.size() == 0 )
            return "NONE";
        return data.poll().getName();
    }

}
