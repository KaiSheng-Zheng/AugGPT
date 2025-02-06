public class MyEvent {
    private MyDate date;
    private String EventName;

    public void setDate(MyDate date) {
        this.date = date;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public MyDate getDate() {
        return date;
    }

    public String getEventName() {
        return EventName;
    }

    public MyEvent(MyDate date, String eventName) {
        this.date = date;
        EventName = eventName;
    }
}
