import java.lang.Comparable;
public class MyEvent  implements Comparable<MyEvent>{
    private MyDate date;
    private String eventName;

    public MyEvent(MyDate date,String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    @Override
    public int compareTo(MyEvent o) {
        if(this.date.getYear() == o.date.getYear()){
            if(this.date.getMonth() == o.date.getMonth()){
                if(this.date.getDay() == o.date.getDay()){
                    return this.getEventName() .compareTo(o.getEventName());
                }else{
                    return this.date.getDay() - o.date.getDay();
                }
            }else{
                return this.date.getMonth() - o.date.getMonth();
            }
        }else{
            return this.date.getYear() - o.date.getYear();
        }
    }
}
