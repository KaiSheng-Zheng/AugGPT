public class MyCalendar
{
    private int capacity;
    String[] events;
    int[] dates;
    private int total=0;
    public MyCalendar(int capacity)
    {
        this.capacity=capacity;
        this.dates=new int[capacity+2];
        events=new String[capacity+2];
    }
    public boolean addEvent(MyDate date, String eventName)
    {
        if(total>=capacity)
            return false;
        int i,j,days,flag=0;
        days=MyDate.toDays(date);
        for(i=0;i<total;i++)
        {
            if(days<dates[i])
            {
                for(j=total;j>i;j--)
                {
                    dates[j]=dates[j-1];
                    events[j]=events[j-1];
                }
                dates[i]=days;
                events[i]=eventName;
                total++;
                flag=1;
                break;
            }
            else if(days==dates[i])
            {
                flag=0;
                for(;i<total&&days==dates[i]&&flag==0;i++)
                {
                    if(events[i].compareTo(eventName)>0)
                    {
                        for(j=total;j>i;j--)
                        {
                            dates[j]=dates[j-1];
                            events[j]=events[j-1];
                        }
                        dates[i]=days;
                        events[i]=eventName;
                        total++;
//                        System.out.printf("i=%d,total=%d\n",i,total);
                        flag=1;
                    }
                }
                if(flag==0)
                {
                    for(j=total;j>i;j--)
                    {
                        dates[j]=dates[j-1];
                        events[j]=events[j-1];
                    }
                    dates[i]=days;
                    events[i]=eventName;
                    total++;
                    flag=1;
                }
                break;
            }
        }
        if(flag==0)
        {
            dates[total]=days;
            events[total++]=eventName;
        }
//        for(i=0;i<total;i++)
//        {
//            System.out.printf("i=%d,dates=%d,event=%s\n",i,dates[i],events[i]);
//        }
//        System.out.println();
        return true;
    }
    public  String finishNextEvent()
    {
        String t=events[0];
        if(total==0)
            return "NONE";
        for(int i=0;i<total-1;i++)
        {
            events[i] = events[i + 1];
            dates[i] = dates[i + 1];
        }
        total--;
        return t;
    }
}
