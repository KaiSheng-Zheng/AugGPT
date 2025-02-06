import java.util.ArrayList;

public class MyCalendar {

    ArrayList<event> calender = new ArrayList<>();
    int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventname) {
        if (calender.size() >= capacity) {
            return false;
        } else {
            event Event = new event(date, eventname);
            calender.add(Event);
        }return true;
    }
    public String finishNextEvent(){
        if (calender.size() == 0){
            return "NONE";
        }else {
            event save = calender.get(0);
            for (int i = 0; i < calender.size(); i++){
                if (MyDate.difference(save.date,calender.get(i).date)>0){
                    save = calender.get(i);
                }else if(MyDate.difference(save.date,calender.get(i).date)==0){
                    if (save.eventname.compareTo(calender.get(i).eventname)>0){
                        save = calender.get(i);
                    }
                }
            }
            calender.remove(save);
            return save.eventname;
        }
    }

}
class event{
    MyDate date;
    String eventname;
    public event(MyDate date,String eventname){
        this.date = date;
        this.eventname = eventname;
    }
}