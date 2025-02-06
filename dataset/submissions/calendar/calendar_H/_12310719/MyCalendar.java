import java.util.ArrayList;

public class MyCalendar {
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    private ArrayList<String> events = new ArrayList<>();

    private ArrayList<MyDate> dates = new ArrayList<>();
    private int num = 0;

    public boolean addEvent(MyDate date, String eventName) {
        if (num >= capacity) {
            return false;
        }
        if(dates.size()==0) {
            dates.add(0, date);
            events.add(0, eventName);
        }
        for (int i = 0; i < capacity-1; i++) {
                if (MyDate.difference(dates.get(i), date) == 0) {
                    if (i != capacity - 1) {
                        dates.add(i + 1, date);
                        if (events.get(i).compareTo(eventName) < 0) {
                            events.add(i, eventName);
                        } else {
                            events.add(i + 1, eventName);
                        }
                        System.out.println(1);
                        num++;
                        return true;
                    }
                }
                if (MyDate.difference(dates.get(i), date) > 0 && MyDate.difference(dates.get(i + 1), date) < 0) {
                    dates.add(i + 1, date);
                    events.add(i + 1, eventName);
                    System.out.println(2);
                    num++;
                    return true;
                }
                if (MyDate.difference(dates.get(i), date) > 0 && dates.get(i + 1) == null) {
                    dates.add(i + 1, date);
                    events.add(i + 1, eventName);
                    System.out.println(3);
                    num++;
                    return true;
                }
                if (MyDate.difference(dates.get(0), date) < 0) {
                    dates.add(0, date);
                    events.add(0, eventName);
                    System.out.println(4);
                    num++;
                    return true;
                }
            }
            return false;
        }
        public String finishNextEvent () {
            if (events.get(0) == null) {
                return "None";
            } else {
                System.out.println(events.get(0));
                events.remove(0);
                System.out.println(events.get(0));
                dates.remove(0);
                num--;
                return events.get(0);
            }
        }
}
