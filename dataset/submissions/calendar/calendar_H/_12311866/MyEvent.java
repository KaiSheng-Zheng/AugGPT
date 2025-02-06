

public class MyEvent implements Comparable<MyEvent> {
    MyDate date;
    String eventname;

    public MyEvent(MyDate date, String eventname) {
        this.date = date;
        this.eventname = eventname;
    }


    @Override
    public int compareTo(MyEvent other){
        int result = this.date.getDate().compareTo(other.date.getDate());
        if(result !=0){
            return  result;
        }
        return this.eventname.compareTo(other.eventname);
    }

//    public MyDate getDate() {
//        return date;
//    }
//
//    public void setDate(MyDate date) {
//        this.date = date;
//    }
//
//    public String getEventname() {
//        return eventname;
//    }
//
//    public void setEventname(String eventname) {
//        this.eventname = eventname;
//    }
}
