public class MyEvent implements Comparable<MyEvent>  {
    private MyDate date;
    private String event;
    public MyEvent(MyDate date,String event){
        this.date=date;
        this.event=event;
    }
    public String getEvent(){
        return event;
    }

    @Override
    public int compareTo(MyEvent o) {
       if (MyDate.difference(date,o.date)==0){
           return event.compareTo(o.event);
       }else {
           return MyDate.difference(date,o.date);
       }
    }
}
