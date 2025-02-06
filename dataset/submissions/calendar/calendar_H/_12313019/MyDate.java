
public class MyDate
{
    private int year;
    private int month;
    private int day;

    static private int[] dayOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static int qian(int y,int m,int d)
    {
        int ret=0;
        dayOfMonth[2]=28;
        if(isRun(y))
        {
            dayOfMonth[2]=29;
        }
        for(int i=1;i<m;i++)
            ret+=dayOfMonth[i];
        dayOfMonth[2]=28;
        return ret+d;
    }
    public static boolean isRun(int year)
    {
        if(year%4==0&&year%100!=0)
        {
            return true;
        }
        else if(year%400==0)
        {
            return true;
        }
        return false;
    }
    public void addDays(int days)
    {
        if(isRun(year))
        {
            dayOfMonth[2]=29;
        }
        int dayCnt=0;
        for(int i=days;i>=1;i--)
        {
            day++;
            if(day==dayOfMonth[month]+1)
            {
                day=1;
                month++;
            }
            if(month==13)
            {
                month=1;
                year++;
                if(isRun(year))
                {
                    dayOfMonth[2]=29;
                }
                else
                {
                    dayOfMonth[2]=28;
                }
            }
        }
    }


    public static int difference(MyDate date1, MyDate date2)
    {
        int cnt=0;
        dayOfMonth[2]=28;
        if(date1.toString().compareTo(date2.toString())<0)
        {
            if(date1.year==date2.year)
            {
                if(isRun(date1.year))
                    cnt-=366;
                else
                    cnt-=365;
            }
            MyDate dateInit= new MyDate(date1.year, date1.month, date1.day);
            if(isRun(date1.year))
            {
                cnt+=366-qian(date1.year,date1.month,date1.day);
            }
            else
            {
                cnt+=365-qian(date1.year,date1.month,date1.day);
            }
            date1.year++;
            while(date1.year<date2.year)
            {
                if(isRun(date1.year))
                    cnt+=366;
                else
                    cnt+=365;
                date1.year++;
            }
            cnt+=qian(date2.year,date2.month,date2.day);
            date1.year= dateInit.year;
            date1.month= dateInit.month;
            date1.day= dateInit.day;

            return -cnt;
        }
        else
        {
            if(date1.year==date2.year)
            {
                if(isRun(date1.year))
                    cnt-=366;
                else
                    cnt-=365;
            }
            MyDate dateInit= new MyDate(date2.year, date2.month, date2.day);
            if(isRun(date2.year))
            {
                cnt+=366-qian(date2.year,date2.month,date2.day);
            }
            else
            {
                cnt+=365-qian(date2.year,date2.month,date2.day);
            }
            date2.year++;
            while(date2.year<date1.year)
            {
                if(isRun(date2.year))
                    cnt+=366;
                else
                    cnt+=365;
                date2.year++;
            }
            cnt+=qian(date1.year,date1.month,date1.day);
            date2.year= dateInit.year;
            date2.month= dateInit.month;
            date2.day= dateInit.day;
            return cnt;
        }


    }
    public String toString()
    {
        return String.format("%04d-%02d-%02d",year,month,day);
    }
}
