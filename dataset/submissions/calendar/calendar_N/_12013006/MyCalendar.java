
import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int index=0;
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public ArrayList<Events> events = new ArrayList<>();

    public boolean addEvent(MyDate date, String eventName){

        if(events.size()>=capacity){
            return false;
        }
        if(events.isEmpty()){

            events.add(new Events(eventName,date));
            return true;
        }else {
            if(events.size()==1){
                if(EventsCompare(events.get(0),new Events(eventName,date))){
                    events.add(0,new Events(eventName,date));
                    return true;
                }
                else{
                    events.add(new Events(eventName,date));
                    return true;
                }
            }
            for(int i=0;i<events.size();i++){
                if(EventsCompare(events.get(i),new Events(eventName,date))){
                    events.add(i,new Events(eventName,date));
                    return true;
                }
            }
        }

        return false;
    }
    public String finishNextEvent(){
        if(index==events.size()){
            return "NONE";
        }

        return events.get(index++).getTitle();
    }
    private boolean EventsCompare(Events e1,Events e2){
        if(e1.getDate().getYear()>e2.getDate().getYear()){
            return true;
        }
        else if(e1.getDate().getYear()==e2.getDate().getYear()){
            if(e1.getDate().getMonth()>e2.getDate().getMonth()){
                return true;
            }
            else if(e1.getDate().getMonth()==e2.getDate().getMonth()){
                if(e1.getDate().getDay()>e2.getDate().getDay()){
                    return true;
                } else if(e1.getDate().getDay()==e2.getDate().getDay()&&e1.getTitle().compareTo(e2.getTitle()) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Events{
        private String title;
        private MyDate date;
        public Events(String title,MyDate date){
            this.title = title;
            this.date = date;
        }
        public String getTitle(){
            return title;
        }
        public MyDate getDate(){
            return date;
        }
    }

}
