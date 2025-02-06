//package A4_1;

import java.util.ArrayList;

public class MyCalendar {
    private int cap;
    private ArrayList<MyEvent> events;
    public MyCalendar(int capacity)
    {
        cap=capacity;
        events=new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName)
    {
        if(events.size()>=cap)return false;
        events.add(new MyEvent(date,eventName));
        return true;
    }

    public String finishNextEvent()
    {
        for(int i=0;i<events.size();i++)
            for(int j=i+1;j<events.size();j++)
                if(events.get(i).compareTo(events.get(j))>0)
                {
                    MyEvent curi=events.get(i),curj=events.get(j);
                    events.remove(i);
                    events.add(i,curj);
                    events.remove(j);
                    events.add(j,curi);
                }
//        for(int i=0;i< events.size();i++)
//            System.out.println(events.get(i).name+" "+events.get(i).date);

        if(events.isEmpty())return "NONE";
        MyEvent NextEvent=events.get(0);
        events.remove(0);
        //if(NextEvent.name=="2333")return "while(true){debug;}";
        return NextEvent.name;
    }
}

class MyEvent implements Comparable<MyEvent>
{
    MyDate date;
    String name;

    public MyEvent(MyDate date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public int compareTo(MyEvent o) {
        if(MyDate.difference(date,o.date)!=0)
            return MyDate.difference(date,o.date);
        else
            return name.compareTo(o.name);
    }
}