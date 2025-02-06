import java.util.ArrayList;
public class MyCalendar {
    int capacity;
    int event = 0;
    ArrayList<MyDate> haveEventDate = new ArrayList<MyDate>();
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date,String eventName) {
        boolean temp = false;
        if (event < capacity) {
            temp = true;
            haveEventDate.add(date);
            date.Event.add(eventName);
            event++;
        }
        return temp;
    }
    public String finishNextEvent(){
        if (haveEventDate.isEmpty()){
            return "NONE";
        }
        MyDate temp = haveEventDate.get(0);
        for (int i = 0;i<haveEventDate.size();i++){
            if (MyDate.difference(temp,haveEventDate.get(i))>0){
                temp = haveEventDate.get(i);
            }
        }
        String tempString = temp.Event.get(0);
        int a=0;
        for (int i = 0;i<temp.Event.size();i++){
            if (tempString.compareTo(temp.Event.get(i))>0){
                tempString = temp.Event.get(i);
                a=i;
            }
        }
        temp.Event.remove(a);
        haveEventDate.remove(temp);
        event--;
        return tempString;
    }
}