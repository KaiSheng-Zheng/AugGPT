public class MyEvent {
    private MyDate date;
    private String eventName;

    public MyEvent(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }


    public MyEvent() {
        this.date = new MyDate(2012,15,16);
        this.eventName = "eventName";
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
}
