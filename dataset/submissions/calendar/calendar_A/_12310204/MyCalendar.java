

import java.util.ArrayList;

public class MyCalendar {

    private int capacity;
    private int count = 0;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    private ArrayList<String> event = new ArrayList<>();

    public boolean addEvent(MyDate date, String eventName) {
        if (count < capacity) {
            String linshi = String.valueOf(date.getDate());
            event.add(linshi + eventName);
            count = count + 1;
            for (int i = 0; i < event.size() - 1; i++) {
                for (int j = i + 1; j < event.size(); j++) {
                    if (event.get(i).compareTo(event.get(j)) > 0) {
                        String temp = event.get(i);
                        event.set(i, event.get(j));
                        event.set(j, temp);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        String end = "";
        if (count != 0) {
            for (int i = 10; i < event.get(0).length(); i++) {
                end = end + event.get(0).charAt(i);
            }
            event.remove(0);
            count = count - 1;
        } else {
            end ="NONE";
        }
        return end;
    }
}
