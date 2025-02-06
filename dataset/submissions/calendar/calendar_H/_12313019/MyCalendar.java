

import java.util.ArrayList;

public class MyCalendar
{
    private int capacity;

    private static ArrayList<Eve> events = new ArrayList<Eve>();
    public MyCalendar(int capacity)
    {
        this.capacity= capacity;
        events=new ArrayList<Eve>();
    }

    public boolean addEvent(MyDate date, String eventName)
    {
        if(events.size()<capacity)
        {
            events.add(new Eve(date,eventName));
            return true;
        }
        return false;
    }

    public String finishNextEvent()
    {
        if(events.isEmpty())
        {
            return "NONE";
        }
        else
        {
            int temp=0;
            for(int i=1;i<events.size();i++)
            {
                if(events.get(i).date.toString().compareTo(events.get(temp).date.toString())<0)
                {
                    temp=i;
                }
                else if(events.get(i).date.toString().compareTo(events.get(temp).date.toString())==0)
                {
                    if(events.get(i).eventName.compareTo(events.get(temp).eventName)<0)
                    {
                        temp=i;
                    }
                }
            }
            String name= events.get(temp).eventName;
            events.remove(temp);
            return name;
        }
    }

    class Eve
    {
        public MyDate date;
        public String eventName;

        public Eve(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }


    }

    public static void main(String[] args) {

        MyDate date1 = new MyDate(2023,1,1);
        MyDate date2= new MyDate(2028,9,30);
        System.out.println(MyDate.difference(date1, date2));

    }
}

