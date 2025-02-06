public class MyEvent {
    private MyDate date;
    private String event;

    public MyEvent(MyDate date, String event) {
        this.date = date;
        this.event = event;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
