import java.util.*;
public class MyDate
{
    private int year;
    private int month;
    private int day;
    static int[] day_month={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year,int month,int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days)
    {
        while(days!=0)
        {
            int cnt=0;
            if(this.year%400==0) cnt=1;
            else if(this.year%4==0 && this.year%100!=0) cnt=1;
            if(this.month!=2) cnt=0;
            if(days<=day_month[this.month]+cnt-this.day)
            {
                this.day+=days;
                days=0;
                continue;
            }
            days-=day_month[this.month]+cnt-this.day+1;
            this.day=1;
            this.month++;
            if(this.month==13)
            {
                this.year++;
                this.month=1;
            }
        }
    }
    public String toString()
    {
        String str;
        str=this.year+"-"+(this.month<10 ? "0"+this.month : this.month)+"-"+ (this.day<10 ? "0"+this.day : this.day);
        return str;
    }
    public static int difference(MyDate date_1,MyDate date_2)
    {
        int res=0,f=1,cnt=0;
        int date_1_year=date_1.year,date_1_month=date_1.month,date_1_day=date_1.day;
        int date_2_year=date_2.year,date_2_month=date_2.month,date_2_day=date_2.day;
        if(date_1_year<date_2_year) f=-1;
        if(date_1_year==date_2_year && date_1_month<date_2_month) f=-1;
        if(date_1_year==date_2_year && date_1_month==date_2_month && date_1_day<date_2_day) f=-1;
        if(f==-1)
        {
            int temp;
            temp=date_1_year;  date_1_year=date_2_year;   date_2_year=temp;
            temp=date_1_month; date_1_month=date_2_month; date_2_month=temp;
            temp=date_1_day;   date_1_day=date_2_day;     date_2_day=temp;
        }
        
        while(date_2_year<date_1_year)
        {
            for(int i=date_2_month;i<=12;i++)
            {
                cnt=0;
                if(date_2_year%400==0) cnt=1;
                else if(date_2_year%4==0 && date_2_year%100!=0) cnt=1;
                if(date_2_month!=2) cnt=0;
                res+=day_month[i]+cnt-date_2_day+1;
                date_2_day=1;
                date_2_month=i+1;
            }
            date_2_year++;
            date_2_month=1;
        }
        for(int i=date_2_month;i<date_1_month;i++)
        {
            cnt=0;
            if(date_2_year%400==0) cnt=1;
            else if(date_2_year%4==0 && date_2_year%100!=0) cnt=1;
            if(date_2_month!=2) cnt=0;
            res+=day_month[i]+cnt-date_2_day+1;
            date_2_month=i+1;
            date_2_day=1;
        }
        res+=date_1_day-date_2_day;
        return res*f;
    }
}
