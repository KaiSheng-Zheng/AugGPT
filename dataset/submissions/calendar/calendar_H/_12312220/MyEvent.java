public class MyEvent implements Comparable<MyEvent> {
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

    @Override
    public int compareTo(MyEvent o) {
       int i = MyDate.difference(date,o.date);
       if (i != 0){
           return i;
       }else {
           return eventname.compareTo(o.eventname);
       }
    }
}
