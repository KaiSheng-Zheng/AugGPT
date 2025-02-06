import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyDate> myDates=new ArrayList<MyDate>();
    private ArrayList<String> events=new ArrayList<String>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String eventName){
        if(myDates.size()==capacity)return false;
        myDates.add(date);
        events.add(eventName);
        return true;
    }
    public String finishNextEvent(){
        if (myDates.size()==0)return "NONE";
        MyDate date0=myDates.get(0);
        String name=new String();
        for (int i=0;i<myDates.size();i++){
            if (MyDate.difference(date0,myDates.get(i))>=0){
                date0=myDates.get(i);
                name=events.get(i);
            }
        }
        int index=0;
        for (int i=0;i<myDates.size();i++){
            if (MyDate.difference(date0,myDates.get(i))==0&&name.compareTo(events.get(i))>=0){
                name=events.get(i);
                index=i;
            }
        }
        myDates.remove(index);
        events.remove(index);
        return name;
    }
}
