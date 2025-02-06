import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int nofe=0;
    private ArrayList<String> name=new ArrayList<String>();
    private ArrayList<MyDate> evdate=new ArrayList<MyDate>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(nofe<capacity){
            nofe+=1;
            name.add(eventName);
            evdate.add(date);
            return true;
        }
        else{
            return false;
        }
    }
    public String finishNextEvent(){
        if(nofe>0){
            int index=0;
            for(int i=0;i<nofe;i++){
                if((MyDate.difference(evdate.get(index),evdate.get(i))>0)|((MyDate.difference(evdate.get(index),evdate.get(i))==0)&((name.get(index)).compareTo(name.get(i))>=0))){
                    index=i;
                }
            }
            String op=name.get(index);
            name.remove(index);
            evdate.remove(index);
            nofe-=1;
            return op;
        }
        else{
            return "NONE";
        }
    }
}
