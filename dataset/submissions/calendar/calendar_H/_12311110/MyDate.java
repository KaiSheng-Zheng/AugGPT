public class MyDate {
    private static int[] mon=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static int[] monRun=new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public static boolean check(int y)
    {
        if((y%400==0)||(y%4==0&&y%100!=0))
            return true;
        return false;
    }
    public String toString()
    {
        if(month>=10&&day>=10)
        return String.format("%d-%d-%d",year,month,day);
        if(month>=10)
            return String.format("%d-%d-0%d",year,month,day);
        if(day>=10)
            return String.format("%d-0%d-%d",year,month,day);
        return String.format("%d-0%d-0%d",year,month,day);
    }
    public void addDays(int days)
    {
            while(days+this.day>mon[this.month])
            {
                if(check(this.year)&&this.month==2&&days+this.day==29)
                {
                    this.day=29;
                    return;
                }
                if(check(this.year)&&this.month==2)
                {
                    days-=monRun[this.month]-this.day;
                    this.day=0;
                    this.month++;
                    continue;
                }
                days-=mon[this.month]-this.day;
                this.day=0;
                this.month++;
                if(this.month==13)
                {
                    this.month=1;
                    this.year++;
                }
            }
            this.day+=days;
    }
    public static int compare(MyDate date1,MyDate date2)
    {
        if(date1.year<date2.year)return 2;
        if(date1.year>date2.year)return 1;
        if(date1.month<date2.month)return 2;
        if(date1.month>date2.month)return 1;
        if(date1.day<date2.day)return 2;
        if(date1.day>date2.day)return 1;
        return 3;
    }
    public static int difference(MyDate date1,MyDate date2)
    {
        //System.out.println(date1.toString());
        //System.out.println(date2.toString());
        int ans=0;
        if(compare(date1,date2)==3)
        {
            //System.out.println(3);
            return 0;
        }
        if(compare(date1,date2)==1)
        {
            if(date1.year>date2.year)
            {
                MyDate date3=new MyDate(date2.year,12,31);
                ans-=difference(date2,date3);
                MyDate date4=new MyDate(date1.year,1,0);
                ans-=difference(date4,date1);
                for(int i=date2.year+1;i<date1.year;i++)
                {
                    if(check(i))
                    {
                        ans+=366;
                    }
                    else ans+=365;
                }
                return ans;
            }
            if(date1.month>date2.month)
            {
                if(check(date1.year))
                {
                    MyDate date3=new MyDate(date2.year,date2.month,monRun[date2.month]);
                    ans-=difference(date2,date3);
                    MyDate date4=new MyDate(date1.year,date1.month,0);
                    ans-=difference(date4,date1);
                    for(int i=date2.month+1;i<date1.month;i++)
                    {
                        ans+=monRun[i];
                    }
                }
                else
                {
                    MyDate date3=new MyDate(date2.year,date2.month,mon[date2.month]);
                    ans-=difference(date2,date3);
                    MyDate date4=new MyDate(date1.year,date1.month,0);
                    ans-=difference(date4,date1);
                    for(int i=date2.month+1;i<date1.month;i++)
                    {
                        ans+=mon[i];
                    }
                }
                return ans;
            }
            ans+=date1.day-date2.day;
            return ans;
        }
        if(compare(date1,date2)==2)
        {
            return -difference(date2,date1);
        }
        return 0;
    }
}
