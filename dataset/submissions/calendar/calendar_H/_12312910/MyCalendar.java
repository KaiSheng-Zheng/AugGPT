import java.util.ArrayList;

public class MyCalendar{
    private int capacity;
    ArrayList<MyDate> events = new ArrayList<>();
    private int counter;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (this.counter >= this.capacity) {
            return false;
        } else {
            events.add(new MyDate(date.getYear(), date.getMonth(), date.getDay(), eventName));
            this.setCounter(this.getCounter() + 1);
            return true;
        }
    }
    public String finishNextEvent() {
        if (this.counter > 0) {
            for (int i = 0; i < events.size() - 1; i++) {
                if (events.get(i).getYear() < events.get(i + 1).getYear()) {
                    MyDate temp = new MyDate(events.get(i).getYear(), events.get(i).getMonth(), events.get(i).getDay(), events.get(i).getEventName());
                    events.get(i).setYear(events.get(i + 1).getYear());
                    events.get(i).setMonth(events.get(i + 1).getMonth());
                    events.get(i).setDay(events.get(i + 1).getDay());
                    events.get(i).setEventName(events.get(i + 1).getEventName());
                    events.get(i + 1).setYear(temp.getYear());
                    events.get(i + 1).setMonth(temp.getMonth());
                    events.get(i + 1).setDay(temp.getDay());
                    events.get(i + 1).setEventName(temp.getEventName());
                } else if (events.get(i).getYear() == events.get(i + 1).getYear() && events.get(i).getMonth() < events.get(i + 1).getMonth()) {
                    MyDate temp = new MyDate(events.get(i).getYear(), events.get(i).getMonth(), events.get(i).getDay(), events.get(i).getEventName());
                    events.get(i).setYear(events.get(i + 1).getYear());
                    events.get(i).setMonth(events.get(i + 1).getMonth());
                    events.get(i).setDay(events.get(i + 1).getDay());
                    events.get(i).setEventName(events.get(i + 1).getEventName());
                    events.get(i + 1).setYear(temp.getYear());
                    events.get(i + 1).setMonth(temp.getMonth());
                    events.get(i + 1).setDay(temp.getDay());
                    events.get(i + 1).setEventName(temp.getEventName());
                } else if (events.get(i).getYear() == events.get(i + 1).getYear() && events.get(i).getMonth() == events.get(i + 1).getMonth() && events.get(i).getDay() < events.get(i + 1).getDay()) {
                    MyDate temp = new MyDate(events.get(i).getYear(), events.get(i).getMonth(), events.get(i).getDay(), events.get(i).getEventName());
                    events.get(i).setYear(events.get(i + 1).getYear());
                    events.get(i).setMonth(events.get(i + 1).getMonth());
                    events.get(i).setDay(events.get(i + 1).getDay());
                    events.get(i).setEventName(events.get(i + 1).getEventName());
                    events.get(i + 1).setYear(temp.getYear());
                    events.get(i + 1).setMonth(temp.getMonth());
                    events.get(i + 1).setDay(temp.getDay());
                    events.get(i + 1).setEventName(temp.getEventName());
                } else if (events.get(i).getYear() == events.get(i + 1).getYear() && events.get(i).getMonth() == events.get(i + 1).getMonth() && events.get(i).getDay() == events.get(i + 1).getDay() && events.get(i).getEventName().compareTo(events.get(i + 1).getEventName()) < 0) {
                    MyDate temp = new MyDate(events.get(i).getYear(), events.get(i).getMonth(), events.get(i).getDay(), events.get(i).getEventName());
                    events.get(i).setYear(events.get(i + 1).getYear());
                    events.get(i).setMonth(events.get(i + 1).getMonth());
                    events.get(i).setDay(events.get(i + 1).getDay());
                    events.get(i).setEventName(events.get(i + 1).getEventName());
                    events.get(i + 1).setYear(temp.getYear());
                    events.get(i + 1).setMonth(temp.getMonth());
                    events.get(i + 1).setDay(temp.getDay());
                    events.get(i + 1).setEventName(temp.getEventName());
                }
            }
            String name = events.get(events.size() - 1).getEventName();
            events.remove(events.size() - 1);
            this.setCounter(this.getCounter() - 1);
            return name;
        } else {
            return "NONE";
        }

    }

}