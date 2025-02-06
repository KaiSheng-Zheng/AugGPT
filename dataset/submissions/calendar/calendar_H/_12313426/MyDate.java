public class MyDate
{
    private final int[]months={31,28,31,30,31,30,31,31,30,31,30,31};
    public int year;
    public int month;
    public int day;
    public String[]event=new String[10000];
    public int s;
    public int To(int year,int month,int day)
    {
        int qwe=0;
        for(int i=0;i<month-1;i++)
        {
            qwe+=months[i];
        }
        qwe+=day;
        if(Leap(year)&&month>=3)
        {
            qwe++;
        }
        return qwe;
    }
    public int Back(int year, int sum)
    {
        int i;
        for(i=0;i<=11;i++)
        {
            int q=months[i];
            if(Leap(year)&&i==1)
            {
                q++;
            }
            if(sum>q)
            {
                sum-=q;
            }
            else
            {
                break;
            }
        }
        return 100*(i+1)+sum;
    }
    public boolean Leap(int year)
    {
        if(year%4==0)
        {
            return year%100!=0||year%400==0;
        }
        else
        {
            return false;
        }
    }
    public int Leaps(int year)
    {
        if(year%4==0)
        {
            if(year%100!=0||year%400==0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }
    public MyDate(int year,int month,int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
        s=0;
    }
    public String toString()
    {
        if(month>=10&&day>=10)
        {
            return year+"-"+month+"-"+day;
        }
        if(month<10&&day>=10)
        {
            return year+"-0"+month+"-"+day;
        }
        if(month>=10&&day<10)
        {
            return year+"-"+month+"-0"+day;
        }
        return year+"-0"+month+"-0"+day;
    }
    public void addDays(int days)
    {
        days+=To(year,month,day);
        while(days>365+Leaps(year))
        {
            days-=365+Leaps(year);
            year++;
        }
        day=Back(year,days)%100;
        month=Back(year,days)/100;
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        int year1=date1.year;
        int year2=date2.year;
        int sum1=date1.To(date1.year,date1.month,date1.day);
        int sum2=date2.To(date2.year,date2.month,date2.day);
        int asd=0;
        if(year1<year2)
        {
            for(int i=year1;i<year2;i++)
            {
                asd+=365+date1.Leaps(i);
            }
            asd=asd-sum1+sum2;
            asd*=-1;
        }
        else if(year1>year2)
        {
            for(int i=year2;i<year1;i++)
            {
                asd+=365+date2.Leaps(i);
            }
            asd=asd-sum2+sum1;
        }
        else
        {
            asd=sum1-sum2;
        }
        return asd;
    }
}