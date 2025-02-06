import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int a;
    private ArrayList<MyEvent> events;
    public MyCalendar(int capacity){
           this.capacity=capacity;
           this.a=0;
           events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        MyDate d=date;
        String s=eventName;
        boolean flag;
        if (a==capacity){
            flag=false;
        }else {
            MyEvent e=new MyEvent(d,s);
            events.add(e);
            a++;
            flag=true;
        }
        return flag;
    }
    public String finishNextEvent(){
        int t=0;
        if (this.events.isEmpty()){
            return "NONE";
        }else {
            for (int i=0;i<events.size();i++){
                if (MyDate.difference(events.get(i).getDate(),events.get(t).getDate())<0||MyDate.difference(events.get(i).getDate(),events.get(t).getDate())==0&&events.get(i).getEventName().compareTo(events.get(t).getEventName())<0){
                    t=i;
                }
            }
            String v=events.get(t).getEventName();
            events.remove(t);
            capacity=capacity-1;
            return v;
        }
    }
}
