import java.util.ArrayList;

public class MyCalendar
{
    private int capacity;
    private int eventAmount;
    public ArrayList<Event> events= new ArrayList<>();
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getEventAmount() {
        return eventAmount;
    }

    public void setEventAmount(int eventAmount) {
        this.eventAmount = eventAmount;
    }

    public MyCalendar(int capacity)
    {
        setCapacity(capacity);
        setEventAmount(0);
    }

    public boolean addEvent(MyDate date, String eventName)
    {
        if(getEventAmount()<getCapacity())
        {
            setEventAmount(getEventAmount()+1);
            Event temp=new Event(date,eventName);
            events.add(temp);
            return true;
        }
         else
        {
            return false;
        }
    }

    public String finishNextEvent()
    {
        if(events.isEmpty()) return "NONE";
        else
        {
            Event temp=events.get(0);
            for(int i=0;i<=events.size()-1;i++)
            {
                if(temp.getDate().countDays()>events.get(i).getDate().countDays()) temp=events.get(i);
                else if((temp.getDate().countDays()==events.get(i).getDate().countDays())&&(temp.getName().compareTo(events.get(i).getName())>0))temp=events.get(i);
            }
            String t=temp.getName();
            events.remove(temp);
            setEventAmount(getEventAmount()-1);
            return t;
        }
    }
}
class Event
{
    private MyDate date;
    private String name;

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event(MyDate date, String name) {
        setDate(date);
        setName(name);
    }
}
