public class MyCalendar
{
    public int capacity;
    private int f;
    public MyDate[]d;
    public MyCalendar(int capacity)
    {
        d=new MyDate[capacity];
        this.capacity=capacity;
        f=0;
    }
    public boolean addEvent(MyDate date,String eventName)
    {
        if(f==capacity)
        {
            return false;
        }
        d[f]=date;
        d[f].s++;
        d[f].event[d[f].s-1]=eventName;
        f++;
        for(int j=0;j<f;j++)
        {
            for(int k=1;k<f-j;k++)
            {
                if(MyDate.difference(d[k-1],d[k])<0)
                {
                    MyDate temp=d[k];
                    d[k]=d[k-1];
                    d[k-1]=temp;
                }
            }
        }
        for(int j=0;j<f-1;j++)
        {
            if(MyDate.difference(d[j],d[j+1])==0)
            {
                for(int l=0;l<d[j].s;l++)
                {
                    for(int k=1;k<d[j].s-l;k++)
                    {
                        if(d[j].event[k-1].compareTo(d[j].event[k])<0)
                        {
                            String str=d[j].event[k];
                            d[j].event[k]=d[j].event[k-1];
                            d[j].event[k-1]=str;
                        }
                    }
                }
            }
        }
        return true;
    }
    public String finishNextEvent()
    {
        if(f==0)
        {
            return "NONE";
        }
        String m=d[f-1].event[d[f-1].s-1];
        d[f-1].s--;
        f--;
        return m;
    }
}