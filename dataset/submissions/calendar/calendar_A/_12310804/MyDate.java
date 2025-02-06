
public class MyDate implements Cloneable
{
    private int year;
    private int month;
    private int day;
    static boolean islp(int year)
    {
        return year%400==0||year%4==0&&year%100!=0;
    }

    public MyDate clone() {
        MyDate p=null;
        try
        {
            p=(MyDate)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return p;
    }
    private int dfm()
    {
        switch (month)
        {
            case 1:
                return 31;
            case 2:
                return islp(year)?29:28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    public MyDate(int year, int month, int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days)
    {
        day+=days;
        while(day>dfm())
        {
            day-=dfm();
            month++;
            if(month>12)
            {
                month=1;
                year++;
            }
        }
    }
    public String toString()
    {
        return String.format("%d",year)+'-'+String.format("%02d",month)+'-'+String.format("%02d",day);
    }
    public boolean less(MyDate date2)
    {
        if(year!=date2.year)return year<date2.year;
        if(month!=date2.month)return month<date2.month;
        return  day<date2.day;
    }

    public static int difference(MyDate date1, MyDate date2)
    {
        int flag=1,cn=0;
        MyDate d1=null,d2=null;
        if(date1.less(date2))
        {
            flag=-1;
            d1=date2.clone();
            d2=date1.clone();
        }
        else
        {
            d1=date1.clone();
            d2=date2.clone();
        }
        while(d1.month!=1||d1.day!=1)
        {
            d1.addDays(1);
            cn--;
        }
        while(d2.month!=1||d2.day!=1)
        {
            d2.addDays(1);
            cn++;
        }
        for(int i=d2.year;i!=d1.year;i++)
        {
            cn+=islp(i)?366:365;
        }
        return cn*flag;
    }
}
