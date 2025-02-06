public class MyEvent {
    private MyDate date;
    private String eventname;

    public MyEvent(MyDate date, String eventname) {
        this.date = date;
        this.eventname = eventname;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
}
