import java.util.ArrayList;
import java.util.Comparator;

public class MyCalendar {
    private int capacity;
    private int count = 0;
    private ArrayList<MyDate> time = new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public void order(ArrayList<MyDate> time) {
        for (int i = 0; i < time.size(); i++) {
            time.get(i).setCount(0);
        }
        for(int i = 0; i < time.size(); ++i) {
            for (MyDate date : time) {
                if (MyDate.difference(time.get(i), date) > 0) {
                    time.get(i).addCount();
                }
            }
        }

        time.sort(Comparator.comparingInt(MyDate::getcount));
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (this.count < this.capacity) {
            date.addEvent(eventName);
            date.order();
            this.count++;
            if (!this.time.contains(date)) {
                this.time.add(date);
                this.order(this.time);
            }

            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if (this.time.isEmpty()) {
            return "NONE";
        } else {
            String s = this.time.get(0).getEvent().get(0);
            this.time.get(0).getEvent().remove(0);
            if (this.time.get(0).getEvent().isEmpty()) {
                this.time.remove(0);
            }
            count--;
            return s;
        }
    }
}