public class MyEvent implements Comparable<MyEvent>{
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
    public int compareTo(MyEvent other) {
        int datecomparison=this.date.compareTo(other.date);
        if (datecomparison!=0){
            return datecomparison;
        }else {
        return this.eventName.compareTo(other.eventName);
    }
 }
}
