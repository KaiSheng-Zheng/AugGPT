import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class MyCalendar {
    private final int capacity;
    private int usedCapacity=0;
    private int finished=0;
    private final ArrayList<MyDate> myDateArrayList=new ArrayList<>();
    public MyCalendar(int capacity)
    {
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName)
    {
        if(this.capacity<=this.usedCapacity-this.finished)
        {
            return false;
        }
        else
        {
            this.usedCapacity++;
            this.myDateArrayList.add(date);
            date.addEventName(eventName);
            return true;
        }
    }
    public String finishNextEvent()
    {
        int haole=0;
        while (haole==0&&this.usedCapacity!=1)
        {
            haole=1;
            for(int i=1;i<this.usedCapacity;i++)
            {
                if(MyDate.difference(myDateArrayList.get(i-1),myDateArrayList.get(i))>0)
                {
                    Collections.swap(myDateArrayList,i-1,i);
                    haole=0;
                }
            }
        }
        for(int i=0;i<this.usedCapacity;i++)
        {
            if(!myDateArrayList.get(i).eventName.isEmpty())
            {
                this.finished++;
                myDateArrayList.get(i).eventName.sort(new Rcompare());
                String rt=myDateArrayList.get(i).eventName.get(0);
                myDateArrayList.get(i).eventName
                        .remove(myDateArrayList.get(i).eventName.get(0));
                return rt;
            }
        }
        return "NONE";
    }
    public static class Rcompare implements Comparator<String>
    {
        public int compare(String ar1,String ar2)
        {
            return ar1.compareTo(ar2);
        }
    }

}