//package A4_1;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private static final int[] m={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year, int month, int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days)
    {
        int yr=getYear(),mo=getMonth(),da=getDay(),dy,dm;
        boolean R=true;
        if(yr%4!=0)R=false;
        else if(yr%100==0&&yr%400!=0)R=false;
        dm=m[mo]-da;
        if(R&&mo==2)dm++;
        dy=dm;
        for(int i=mo+1;i<=12;i++)
        {
            dy+=m[i];
            if(R&&i==2)dy++;
        }

         if(days>dy)
         {
             days-=dy;
             int nx;
             yr++;
             if(yr%4!=0||(yr%100==0&&yr%400!=0))nx=365;
             else nx=366;
             while(days>nx)
             {
                 days-=nx;
                 yr++;
                 if(yr%4!=0||(yr%100==0&&yr%400!=0))nx=365;
                 else nx=366;
             }
             if(yr%4!=0)R=false;
             else if(yr%100==0&&yr%400!=0)R=false;
             for(int i=1;i<=12;i++)
             {
                 int thm;//this month
                 thm=m[i];
                 if(i==2&&R)thm++;
                 if(days>thm)days-=thm;
                 else {mo=i;break;}
             }
             setYear(yr);setMonth(mo);setDay(days);
         }
         else {
             if(days>dm)
             {
                 days-=dm;
                 for(int i=mo+1;i<=12;i++)
                 {
                     int thm;//this month
                     thm=m[i];
                     if(i==2&&R)thm++;
                     if(days>thm)days-=thm;
                     else {mo=i;break;}
                 }
                 setMonth(mo);setDay(days);
             }
             else {
                 setDay(days+da);
             }
         }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString()
    {
        return String.format("%04d-%02d-%02d",getYear(),getMonth(),getDay());
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        boolean IF=false;//true:date1<date2 false:date1>date2
        if(date1.getYear()<date2.getYear())IF=true;
        else if(date1.getYear()==date2.getYear())
            {
                if(date1.getMonth()<date2.getMonth())IF=true;
                else if(date1.getMonth()==date2.getMonth())
                    {
                        if(date1.getMonth()<date2.getMonth())IF=true;
                        else if(date1.getDay()==date2.getDay())return 0;
                    }
            }
        if(!IF)//date1 is later than date2
        {
            MyDate date3=date2;
            date2=date1;
            date1=date3;
        }

        int ans=0;
        for(int i=date1.getYear()+1;i<=date2.getYear()-1;i++)
        {
            if(i%4!=0){ans+=365;continue;}
            if(i%100==0&&i%400!=0)ans+=365;
            else ans+=366;
        }

        int yr=date1.getYear(),mo=date1.getMonth(),da=date1.getDay(),dy,dm;
        boolean R=true;
        if(yr%4!=0)R=false;
        else if(yr%100==0&&yr%400!=0)R=false;
        dm=m[mo]-da;
        if(R&&mo==2)dm++;
        dy=dm;
        for(int i=mo+1;i<=12;i++)
        {
            dy+=m[i];
            if(R&&i==2)dy++;
        }
        ans+=dy;
        /*int cnt=0;
        for(int i=1;i<mo;i++)
        {
            cnt+=m[i];
            if(R&&i==2)cnt++;
        }
        if(R)ans+=366-cnt;
        else ans+=365-cnt;*/

        yr=date2.getYear();mo=date2.getMonth();da=date2.getDay();
        R=true;
        if(yr%4!=0)R=false;
        else if(yr%100==0&&yr%400!=0)R=false;
        for(int i=1;i<mo;i++)
        {
            ans+=m[i];
            if(R&&i==2)ans++;
        }
        ans+=da;

        if(date1.getYear()==date2.getYear())
        {
            if(R)ans-=366;
            else ans-=365;
        }

        if(IF)return -ans;
        else return ans;
    }
}
