import java.util.ArrayList;
public class MyCalendar {
    private final int capacity;
    private int count=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    ArrayList<MyDate> Dates = new ArrayList<>();
    ArrayList<String> Events = new ArrayList<>();
    public boolean addEvent(MyDate date, String eventName){
        if (count<capacity) {
            Dates.add(date);
            Events.add(eventName);
            count += 1;
            return true;
        }
        else return false;
    }
    public int EarliestEvent(){
        int index=0;
        String early=Dates.get(0).toString();
        for (int i = 1; i < Dates.size(); i++) {


            if (Dates.get(i).toString().compareTo(early)<0){
                early=Dates.get(i).toString();
                index=i;
            }else if(Dates.get(i).toString().compareTo(early)==0){
                if(Events.get(i).compareTo(Events.get(index))<0){
                    early=Dates.get(i).toString();
                    index=i;
                }
            }

        }
        return index;

    }
    public String finishNextEvent(){
        if(count>0){
        String event = Events.get(EarliestEvent());
        Events.remove(Events.get(EarliestEvent()));
        Dates.remove(Dates.get(EarliestEvent()));
        count=count-1;
        return event;}
        else return "NONE";

    }
}
