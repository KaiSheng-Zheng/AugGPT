import java.util.ArrayList;
public class MyCalendar {
    public int capacity;
    public int count;
    public ArrayList<MyDate> dates = new ArrayList<MyDate>();
    public ArrayList<String> events = new ArrayList<String>();
    public MyCalendar(int capacity)
    {
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String eventName)
    {
        if(count==capacity)
        {
            return false;
        }
        else
        {
            count++;
            dates.add(date);
            events.add(eventName);
            return true;
        }
    }
    public String finishNextEvent()
    {
        if(count==0)
        {
            return "NONE";
        }
        int early=0;
        for(int i=1;i<dates.size();i++)
        {
            if(MyDate.difference(dates.get(early),dates.get(i))>0)
            {
                early=i;
            }
            if(MyDate.difference(dates.get(early),dates.get(i))==0)
            {
                if(events.get(early).compareTo(events.get(i))>0)
                {
                    early=i;
                }
            }
        }
        dates.remove(early);
        String s=events.get(early);
        events.remove(early);
        count--;
        return s;
    }
}
