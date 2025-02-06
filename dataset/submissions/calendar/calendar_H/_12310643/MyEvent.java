public class MyEvent {
    private MyDate date;
    private String EventName;

    public void setDate(MyDate date) {
        this.date = date;
    }

    public MyDate getDate() {
        return date;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }
    public MyEvent(MyDate date,String EventName){
        this.date=date;
        this.EventName=EventName;
    }
}
