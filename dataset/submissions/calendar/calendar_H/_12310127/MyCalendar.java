import java.util.ArrayList;
public class MyCalendar {
    private final int capacity;
    private ArrayList<String> Events = new ArrayList<>();
    private ArrayList<MyDate> Date = new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(Date.size() >= this.capacity){
            return false;
        }
        else if(Date.size() >= 1){
            this.Date.add(date);
            this.Events.add(eventName);
            for(int i = 0; i < Date.size() - 1; i++){
                int minindex = i;
                for(int ii = i ; ii < Date.size() - 1; ii++){
                    if(MyDate.difference(this.Date.get(minindex), this.Date.get(ii + 1)) > 0){
                         minindex = ii + 1;
                    }
                    else if(MyDate.difference(this.Date.get(minindex), this.Date.get(ii + 1)) == 0 &&
                            this.Events.get(minindex).compareTo(this.Events.get(ii + 1)) > 0){
                        minindex = ii + 1;
                    }
                }
                MyDate tempdate = this.Date.get(minindex);
                String tempevent = this.Events.get(minindex);
                this.Date.set(minindex, this.Date.get(i));
                this.Events.set(minindex, this.Events.get(i));
                this.Date.set(i, tempdate);
                this.Events.set(i, tempevent);
            }
            return true;
        }
        else{
            this.Date.add(date);
            this.Events.add(eventName);
            return true;
        }
    }
    public String finishNextEvent(){
        if(Events.isEmpty()){
            return "NONE";
        }
        String tobefinishedEvent = this.Events.get(0);
        this.Events.remove(0);
        this.Date.remove(0);
        return tobefinishedEvent;
    }
}