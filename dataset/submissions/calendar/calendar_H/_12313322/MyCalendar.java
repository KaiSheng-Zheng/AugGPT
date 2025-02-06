import java.util.*;
public class MyCalendar
{
    int tot;
    public MyCalendar(int capacity)
    {
        this.tot=capacity;
    }
    Queue<Pair> a=new PriorityQueue<>(cmp);
    public boolean addEvent(MyDate date,String eventName)
    {
        if(a.size()==tot) return false;
        Pair pair=new Pair();
        pair.Date=date;
        pair.Event=eventName;
        a.add(pair);
        return true;
    }
    public String finishNextEvent()
    {
        if(a.size()==0) return "NONE";
        return a.poll().Event;
    }
    public static Comparator<Pair> cmp=new Comparator<Pair>()
        {
            public int compare(Pair p1,Pair p2)
            {
                int diff=MyDate.difference(p1.Date,p2.Date);
                if(diff!=0) return diff;
                String str1=p1.Event,str2=p2.Event;
                int l1=str1.length(),l2=str2.length();
                for(int i=0;i<Math.min(l1,l2);i++)
                {
                    if(str1.charAt(i)-'0'<str2.charAt(i)-'0') return -1;
                    if(str1.charAt(i)-'0'>str2.charAt(i)-'0') return 1;
                }
                return l1-l2;
            }
        };
}
class Pair
{
    MyDate Date;
    String Event;
}