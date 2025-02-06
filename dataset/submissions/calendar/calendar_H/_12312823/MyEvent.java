

import java.util.Objects;

public class MyEvent  {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEvent myEvent = (MyEvent) o;
        return Objects.equals(date, myEvent.date) && Objects.equals(eventName, myEvent.eventName);
    }


    }








