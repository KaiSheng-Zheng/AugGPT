import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int times;
    private ArrayList<String> event=new ArrayList<>();
    private ArrayList<MyDate> date = new ArrayList<>();
    public int getTimes() {
        return times;
    }
    public void setTimes(int times) {
        this.times = times;
    }
    public ArrayList<MyDate> getDate() {
        return date;
    }
    public void setDate(ArrayList<MyDate> date) {
        this.date = date;
    }
    public ArrayList<String> getEvent() {
        return event;
    }
    public void setEvent(ArrayList<String> event) {
        this.event = event;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public MyCalendar(int capacity){
        this.times=0;
        this.capacity=capacity;
    }
    public int much(MyDate date){
        return date.getYear()*10000+ date.getMonth()*100+ date.getDay();
    }
    public boolean addEvent(MyDate date,String eventName){
        if(getTimes()<getCapacity()){
            this.date.add(date);
            this.event.add(eventName);
            setTimes(getTimes()+1);
            return true;
        }
        else
            return false;
    }
    public String finishNextEvent(){
        if(getTimes()>0) {
            int num = 0;
            for (int counter = 1; counter < getTimes(); counter++) {
                if (much(date.get(num)) > much(date.get(counter))) {
                    num = counter;
                } else if (much(date.get(num)) == much(date.get(counter))) {
                    if (event.get(num).compareTo(event.get(counter)) > 0) {
                        num = counter;
                    }
                }
            }
            String a = event.get(num);
            setTimes(getTimes() - 1);
            this.date.remove(num);
            this.event.remove(num);
            return a;
        }
        else
            return "NONE";
    }
}
