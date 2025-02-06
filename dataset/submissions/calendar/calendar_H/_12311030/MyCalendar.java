import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<Event>events;
    private   int flag=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
       this.events=new ArrayList<>();
    }public boolean addEvent(MyDate date,String eventName){
       if(events.size()<capacity){
            Event event=new Event(date,eventName);
            events.add(event);
           for(int i=0;i<events.size();i++){
               for(int j=0;j<events.size()-i-1;j++){
                   if(MyDate.difference(events.get(j).date,events.get(j+1).date)>0){
                       Event temp=events.get(j);
                       events.set(j,events.get(j+1));

                       events.set(j+1,temp);
                   }
               }
           }for(int i=0;i<events.size();i++){
               for(int j=0;j<events.size()-i-1;j++){
                   if(events.get(j).name.compareTo(events.get(j+1).name)>0&&
                           MyDate.difference(events.get(j).date,events.get(j+1).date)==0){
                       Event temp=events.get(j);
                       events.set(j,events.get(j+1));
                       events.set(j+1,temp);

                   }
               }
           }
           return true;
        }
       return false;

    }
    public String finishNextEvent(){

        if(events.isEmpty()||flag==events.size()){
            return "NONE";
        }else{
            String s=events.get(flag).name;
            events.remove(flag);


            return s;
        }

    }private class Event{
       private MyDate date;
        private String name;
        public Event(MyDate date,String name){
            this.date=date;this.name=name;
        }
    }

}
