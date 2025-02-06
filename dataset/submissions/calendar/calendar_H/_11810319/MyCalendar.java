import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    int counter;
    ArrayList<MyDate> date = new ArrayList<>(0);
    ArrayList<String> eventName = new ArrayList<>(0);
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        this.date.add(date);
        this.eventName.add(eventName);
        counter += 1;
        if(counter > capacity){
            return false;
        }else {
            return true;
        }
    }


    public String finishNextEvent(){
        int num = 0;
        if(date.size() == 0){
            return "NONE";
        }else if(date.size() == 1){
            MyDate d = date.get(0);
            String s = eventName.get(0);
            date.remove(num);
            eventName.remove(num);
            return s;
        }else {
            MyDate d = date.get(0);
            String s = eventName.get(0);
            for(int c = 0; c < this.date.size(); c++){
                if(compareTo(d,date.get(c))){
                    d =date.get(c);
                    s = eventName.get(c);
                    num = c;
                }
            }
            date.remove(num);
            eventName.remove(num);
            return s;
        }
    }

    public boolean compareTo(MyDate date1, MyDate date2){
        if(date1.getYear()>date2.getYear()){
            return true;
        }else if(date1.getYear()==date2.getYear()){
            if(date1.getMonth()>date2.getMonth()){
                return true;
            }else if(date1.getMonth()==date2.getMonth()){
                if(date1.getDay()>=date2.getDay()){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public ArrayList<MyDate> getDate() {
        return date;
    }
}
