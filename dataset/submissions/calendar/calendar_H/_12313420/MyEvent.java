public class MyEvent implements Comparable<MyEvent> {
    private MyDate date;
    private String eventName;

    public MyEvent(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int compareTo(MyEvent o) {
        if (MyDate.difference(date, o.date) != 0) {
            return MyDate.difference(date, o.date);
        } else {
            return eventName.compareTo(o.eventName);
        }
    }
}