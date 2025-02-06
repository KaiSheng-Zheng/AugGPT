import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    private ArrayList<MyDate> dates = new ArrayList<MyDate>();
    private int sum;

    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.sum = 0;
        ArrayList<MyDate> dates = new ArrayList<MyDate>();
    }

    public  void addDate (MyDate date1,ArrayList<MyDate>dates) {
        if (dates.size() == 0 || MyDate.difference(dates.get(dates.size() - 1), date1) < 0){
            dates.add(date1);
            return;
        }else if (MyDate.difference(dates.get(0),date1) > 0){
            dates.add(0,date1);
        }
        for (int i = 0; i < dates.size() - 1; i++) {
            if (MyDate.difference(dates.get(i), date1 ) < 0 &&
                    MyDate.difference(dates.get(i+1), date1) > 0){
                dates.add(i+1,date1);
                break;
            }
        }

    }
    public void addevents(MyDate date , String eventName){
        if (date.events.size()==0 || date.events.get(date.events.size()-1).compareTo(eventName) <= 0){
            date.events.add(eventName);
            return;
        } else if (date.events.get(0).compareTo(eventName) >= 0) {
            date.events.add(0,eventName);
        }
        for (int i = 0; i < date.events.size()-1; i++) {
            if (date.events.get(i).compareTo(eventName)<0 &&
                    date.events.get(i+1).compareTo(eventName)>=0
                ){
                date.events.add(i+1,eventName);
                break;
            }
        }
    }
    public boolean addEvent(MyDate date,String eventName){
        if (sum < this.capacity){
            addDate(date,dates);
            addevents(date,eventName);

            sum++;
            return true;
        } else
            return false;
    }
    public String finishNextEvent(){
        if(dates.size() > 0) {
            String s1 = dates.get(0).events.get(0);
            dates.get(0).events.remove(0);
            if (dates.get(0).events.size()==0){
                dates.remove(0);
            }
            sum--;
            return s1;
        }else {
            return "NONE";
        }
    }
}