import java.util.Comparator;
        import java.util.PriorityQueue;
public class MyCalendar{
    private int capacity;
    public MyCalendar(int capacity)
    {
        this.capacity=capacity;
    }
    public static int t=0;
    PriorityQueue<sort>queue=new PriorityQueue<>(new Comparator<sort>() {
        @Override
        public int compare(sort o1, sort o2) {
            if(Integer.parseInt(o1.date.sss())==Integer.parseInt(o2.date.sss()))
            {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.things,o2.things);
            }
            else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.date.sss(),o2.date.sss());
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
            sort s=new sort(date,eventName);
            queue.add(s);
        }
        return true;
    }
    public String finishNextEvent()
    {
        if(queue.peek()!=null)
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
class sort{
    MyDate date;
    String things;
    public sort(MyDate date,String things)
    {
        this.date=date;
        this.things=things;
    }
}
