public class MyEvent {
    private MyDate date;
    private String eventName;

    public MyEvent(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    public MyDate getDate() {
        return date;
    }

    public String getEventName() {
        return eventName;
    }
}
