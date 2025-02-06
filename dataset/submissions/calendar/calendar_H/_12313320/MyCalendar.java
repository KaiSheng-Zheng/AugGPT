import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    ArrayList<MyEvent> list= new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(list.size()>=capacity){
            return false;
        }
        else {
            MyEvent temp=new MyEvent();
            temp.date=date;
            temp.name=eventName;
            list.add(temp);
            return true;
        }
    }

    public String finishNextEvent(){
        if(list.isEmpty()){
            return "NONE";
        }
        int xx=0;
        MyEvent temp= list.get(0);
        for(int i=1;i<list.size();i++)
        {
            MyEvent now= list.get(i);
            int x=MyDate.difference(now.date,temp.date);
            if(x<0)
            {
                temp=now;
                xx=i;
            }
            else if(x==0){
                if(now.name.compareTo(temp.name)<0){
                    temp=now;
                    xx=i;
                }
            }
        }
        list.remove(xx);
        return temp.name;
    }
}
class MyEvent{
    MyDate date;
    String name;
}