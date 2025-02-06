import java.util.ArrayList;
import java.util.List;
public class MyCalendar {
    private int capacity;
    private MyDate date;
    private List<MyDate> myDates=new ArrayList<>();
    private List<String> eventname=new ArrayList<>();
    public MyCalendar(int capacity){
        setCapacity(capacity);
    }
    public boolean addEvent(MyDate date, String eventName){

        if(eventname.size()<getCapacity()){
            eventname.add(eventName);
            myDates.add(date);
            return true;
        }

        return false;

    }
    public String finishNextEvent(){
        String tobereturned;
        if(myDates.isEmpty()){
            return "NONE";
        }
        else{
            for(int i=0;i<myDates.size();i++){
                for(int i2=0;i2<myDates.size();i2++){
                    if(MyDate.difference(myDates.get(i),myDates.get(i2))<0){
                        MyDate midday=myDates.get(i);
                        String midevent=eventname.get(i);
                        myDates.set(i,myDates.get(i2));
                        eventname.set(i,eventname.get(i2));
                        myDates.set(i2,midday);
                        eventname.set(i2,midevent);
                    }
                    else if(MyDate.difference(myDates.get(i),myDates.get(i2))==0){
                        if(eventname.get(i).compareTo(eventname.get(i2))<0){
                            MyDate midday=myDates.get(i);
                            String midevent=eventname.get(i);
                            myDates.set(i,myDates.get(i2));
                            eventname.set(i,eventname.get(i2));
                            myDates.set(i2,midday);
                            eventname.set(i2,midevent);
                        }
                    }
                }
            }
            tobereturned=eventname.get(0);
            myDates.remove(0);
            eventname.remove(0);
            return tobereturned;
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setDate(MyDate date) {
        this.date = date;
    }
    public MyDate getDate(MyDate myDate) {
        return date;
    }
}
