import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private static int id=0;
    ArrayList<MyDate> dates=new ArrayList<>();
    ArrayList<String> eventNames=new ArrayList<>();
    ArrayList<Boolean> flag=new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(capacity == 0) return false;
        else{
            capacity-=1;
            dates.add(date);
            eventNames.add(eventName);
            flag.add(true);
            id+=1;
            return true;
        }
    }
    public String finishNextEvent(){
        boolean flagFNE=false;
        MyDate mind = new MyDate(9999,12,31);
        String minn = "";
        int mark=0;
        for(int i=0;i<dates.size();i++){
            if(flag.get(i)) {
                flagFNE = true;
                if (MyDate.cmp(mind, dates.get(i)) == 1) {
                    mind = dates.get(i);
                    minn = eventNames.get(i);
                    mark=i;
                }
                else if (MyDate.cmp(mind, dates.get(i)) == 0) {
                    if (minn.compareTo(eventNames.get(i)) > 0) {
                        mind = dates.get(i);
                        minn = eventNames.get(i);
                        mark=i;
                    }
                }
            }
        }
        if(!flagFNE) return "NONE";
        else {
            flag.set(mark,false);
            capacity+=1;
            return minn;
        }
    }
}