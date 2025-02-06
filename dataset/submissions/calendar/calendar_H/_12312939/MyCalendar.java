import java.util.*;
public class MyCalendar {
    private int capacity;
    private List<MyDate> dates;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.dates = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (dates.size() >= capacity) {
            return false;
        } else {
            date.addEvent(eventName);
            dates.add(date);
            return true;
        }
    }
    public String finishNextEvent() {
        Optional<MyDate> nextDate = dates.stream()
                .filter(date -> !date.getEvents().isEmpty())
                .min(Comparator.comparing(MyDate::getDay));
        if (nextDate.isPresent()) {
            return nextDate.get().getEvents().stream().findFirst().orElse("NONE");
        } else {
            return "NONE";
        }
    }
}