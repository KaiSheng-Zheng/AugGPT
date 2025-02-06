import java.util.Comparator;
import java.util.PriorityQueue;
public class MyCalendar{
    private int capacity;
    public MyCalendar(int capacity)
    {
        this.capacity=capacity;
    }
    public static int t=0;
    PriorityQueue<S>queue=new PriorityQueue<>(new Comparator<S>() {
        @Override
        public int compare(S o1, S o2) {
            if(Integer.parseInt(o1.date.str())==Integer.parseInt(o2.date.str()))
            {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.things,o2.things);
            }
            else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.date.str(),o2.date.str());
            }
        }
    });
    public boolean addEvent(MyDate date, String eventName)
    {
        t++;
        if(t>capacity)
        {
            t--;
            return false;
        }
        else {
            S s=new S(date,eventName);
            queue.add(s);
        }
        return true;
    }
    public String finishNextEvent()
    {
        if(t>0)
        {
            t--;
            String sss=queue.peek().things;
            queue.poll();
            return sss;
        }
         else
             return "NONE";
    }
}
class S{
    MyDate date;
    String things;
    public S(MyDate date,String things)
    {
        this.date=date;
        this.things=things;
    }
}
