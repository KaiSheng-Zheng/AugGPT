import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int n=0;

    ArrayList<String> Event =new ArrayList<String>();
    ArrayList<MyDate> Date =new ArrayList<MyDate>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){

        if (capacity>0){
            n++;
            capacity--;
            Event.add(eventName);
            Date.add(date);

            return true;
        }
        else return false;
    }
    public String finishNextEvent(){
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (MyDate.difference(Date.get(i),Date.get(j))>0){
                    MyDate a=Date.get(i);
                    MyDate b=Date.get(j);
                    String c=Event.get(i);
                    String d=Event.get(j);
                    Date.set(i,b);
                    Date.set(j,a);
                    Event.set(j,c);
                    Event.set(i,d);
                }
                else if (MyDate.difference(Date.get(i),Date.get(j))==0){
                    if (Event.get(i).compareTo(Event.get(j))>0){
                        String c=Event.get(i);
                        String d=Event.get(j);
                        Event.set(j,c);
                        Event.set(i,d);
                    }
                }
                else ;
            }
        }

        if (n>0) {
            n--;
            capacity++;
            String a=Event.get(0);
            Event.remove(0);
            Date.remove(0);
            return a;
        }
        else return "NONE";
    }
}
