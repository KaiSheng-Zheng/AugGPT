import java.util.Arrays;
import java.util.Comparator;

class Thing
{
    private MyDate date;
    private String name;
    Thing(MyDate date,String name)
    {
        this.date=date;
        this.name=name;
    }

    public MyDate getDate()
    {
        return date;
    }

    public String getName()
    {
        return name;
    }
}
public class MyCalendar
{
    int top,cap;
    Thing[] things;
    public MyCalendar(int capacity)
    {
        top=0;
        cap=capacity;
        things=new Thing[capacity];
    }
    public boolean addEvent(MyDate date, String eventName)
    {
        if(top==cap)return  false;
        things[top++]=new Thing(date,eventName);
        Arrays.sort(things,0,top,new Comparator<Thing>()
        {
            public int compare(Thing x,Thing y)
            {
                return x.getDate().equals(y.getDate())?y.getName().compareTo(x.getName()):(y.getDate().less(x.getDate())?-1:1);
            }
        });
        return true;
    }
    public String finishNextEvent()
    {
        if(top!=0)return things[--top].getName();
        else return "NONE";
    }
}
