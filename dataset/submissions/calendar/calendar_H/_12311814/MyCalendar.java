import java.util.ArrayList;
import java.util.Comparator;

public class MyCalendar {
    ArrayList<String[]> data = new ArrayList<>();
    private int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {

        if (data.size() == capacity) {
            return false;
        }

        data.add(new String[] { date.getTimeStamp(), eventName });
        return true;
    }

    public String finishNextEvent() {

        if (data.size() == 0) {
            return "NONE";
        }

        data.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {

                if (o1[0].compareTo(o2[0]) == 0) {
                    return o1[1].compareTo(o2[1]);
                }

                return o1[0].compareTo(o2[0]);
            }
        });

        String event = data.get(0)[1];
        data.remove(0);
        return event;
    }
}
