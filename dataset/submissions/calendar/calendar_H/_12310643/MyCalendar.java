import java.util.ArrayList;

public class MyCalendar {
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    private ArrayList<MyEvent> events=new ArrayList<MyEvent>();

    public ArrayList<MyEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<MyEvent> events) {
        this.events = events;
    }
    public boolean addEvent(MyDate date, String eventName){
        this.num++;
        setNum(num);
        if(getNum()>getCapacity()) {
            num--;
            return false;
        }
        else{
            MyEvent during=new MyEvent(date,eventName);
            events.add(during);
            setEvents(events);
            return true;
        }
    }
    public String finishNextEvent(){
        if(events.isEmpty()){
            return "NONE";
        }else{
            this.num--;
            setNum(num);
            ArrayList <MyEvent> suspect1=new ArrayList<MyEvent>();
            int smallyear= events.get(0).getDate().getYear();
            for(int i=0;i<events.size();i++){
                smallyear=Math.min(smallyear,events.get(i).getDate().getYear());
            }
            for(int i=0;i<events.size();i++){
                if(smallyear==events.get(i).getDate().getYear())
                    suspect1.add(events.get(i));
            }
            int smallmonth=suspect1.get(0).getDate().getMonth();
            for(int i=0;i< suspect1.size();i++){
                smallmonth=Math.min(smallyear,suspect1.get(i).getDate().getMonth());
            }
            ArrayList <MyEvent> suspectmonth=new ArrayList<MyEvent>();
            for(int i=0;i<suspect1.size();i++){
                if(smallmonth==suspect1.get(i).getDate().getMonth())
                    suspectmonth.add(suspect1.get(i));
            }
            int smallday=suspectmonth.get(0).getDate().getDay();
            for(MyEvent evv:suspectmonth){
                smallday=Math.min(smallday,evv.getDate().getDay());
            }
            ArrayList <MyEvent> mfin=new ArrayList<MyEvent>();
            for(MyEvent evv:suspectmonth){
                if(smallday==evv.getDate().getDay()){
                    mfin.add(evv);
                }
            }
            if(mfin.size()==1){
                events.remove(mfin.get(0));
                return mfin.get(0).getEventName();
            }else{
                MyEvent finn=mfin.get(0);
                for(int i=0;i<mfin.size();i++){
                    int pr=finn.getEventName().compareTo(mfin.get(i).getEventName());
                    if(pr>0)
                        finn=mfin.get(i);
                }
                events.remove(finn);
                return finn.getEventName();
            }
        }
    }
}
