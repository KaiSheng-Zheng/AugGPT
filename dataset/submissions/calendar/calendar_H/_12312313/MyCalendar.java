import java.util.ArrayList;
import java.util.Date;

public class MyCalendar {
    private int capacity;
    private int number=0;

    private  ArrayList<String>  Date=new ArrayList<String> ();
    private  ArrayList<String>  EventName=new ArrayList<String> ();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        number+=1;
        boolean shi;
        if(number<=capacity){
            if(number == 1){
                Date.add(date.toString());
                EventName.add(eventName);
            }else{
                shi=true;
                for(int i=0;i<number-1 && shi==true;i++){
                    if(Date.get(i).compareTo(date.toString())>0){
                        Date.add(i,date.toString());
                        EventName.add(i,eventName);
                        shi=false;
                    } else if (Date.get(i).compareTo(date.toString())==0) {
                        if(EventName.get(i).compareTo(eventName)<0){
                            Date.add(i+1,date.toString());
                            EventName.add(i+1,eventName);
                            shi=false;
                        } else if (EventName.get(i).compareTo(eventName)>=0) {
                            Date.add(i,date.toString());
                            EventName.add(i,eventName);
                            shi=false;
                        }
                    }
                }

                if(shi) {
                    Date.add(date.toString());
                    EventName.add(eventName);
                }
            }
            return true;
        }else{
            number=number-1;
            return false;
        }
    }

    public String finishNextEvent(){
        number=number-1;
        if(number<0){
            number=0;
            return "NONE";
        }else{
            String ear= EventName.get(0);
            EventName.remove(0);
            Date.remove(0);
            return ear;
        }
    }
}

