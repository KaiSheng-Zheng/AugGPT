public class MyDate{
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public void addDays(int days)
    {
        for(int i=1;i<=days;i++)
        {
            day++;
            if(month==1||month==3||month==5||month==7||month==8||month==10)
            {
                if(day==32)
                {
                    month++;
                    day=1;
                }
            }
            else if(month==4||month==6||month==9||month==11)
            {
                if(day==31)
                {
                    month++;
                    day=1;
                }
            }
            else if(month==2)
            {
                if(year%4==0&&year%100!=0)
                {
                    if(day==30)
                    {
                        month++;
                        day=1;
                    }
                }
                else if(year%400==0)
                {
                    if(day==30)
                    {
                        month++;
                        day=1;
                    }
                }
                else {
                    if(day==29)
                    {
                        month++;
                        day=1;
                    }
                }
            }
            else if(month==12&&day==32)
            {
                year++;
                month=1;
                day=1;
            }
        }
    }
    public String toString()
    {
        return String.format("%4d",year)+"-"+String.format("%02d",month)+"-"+String.format("%02d",day);
    }
    public String sss()
    {
        return String.format("%4d",year)+String.format("%02d",month)+String.format("%02d",day);
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        boolean da1=false;
        if(date1.year==date2.year)
        {
            if(date1.month==date2.month)
            {
                if(date1.day==date2.day)return 0;
                else if(date1.day>date2.day)da1=true;
            }
            else if(date1.month>date2.month)da1=true;
        }
        else if(date1.year>date2.year)da1=true;
        if(!da1)
        {
            int year=date1.year;
            int month=date1.month;
            int day=date1.day;
            int t=0;
            while(true)
            {
                if(year==date2.year&&month==date2.month&&day==date2.day)
                {
                    return -t;
                }
                t++;
                day++;
                if(month==1||month==3||month==5||month==7||month==8||month==10)
                {
                    if(day==32)
                    {
                        month++;
                        day=1;
                    }
                }
                else if(month==4||month==6||month==9||month==11)
                {
                    if(day==31)
                    {
                        month++;
                        day=1;
                    }
                }
                else if(month==2)
                {
                    if(year%4==0&&year%100!=0)
                    {
                        if(day==30)
                        {
                            month++;
                            day=1;
                        }
                    }
                    else if(year%400==0)
                    {
                        if(day==30)
                        {
                            month++;
                            day=1;
                        }
                    }
                    else {
                        if(day==29)
                        {
                            month++;
                            day=1;
                        }
                    }
                }
                else if(month==12&&day==32)
                {
                    year++;
                    month=1;
                    day=1;
                }
            }
        }
        else
        {
            int year=date2.year;
            int month=date2.month;
            int day=date2.day;
            int t=0;
            while(true)
            {
                if(year==date1.year&&month==date1.month&&day==date1.day)
                {
                    return t;
                }
                t++;
                day++;
                if(month==1||month==3||month==5||month==7||month==8||month==10)
                {
                    if(day==32)
                    {
                        month++;
                        day=1;
                    }
                }
                else if(month==4||month==6||month==9||month==11)
                {
                    if(day==31)
                    {
                        month++;
                        day=1;
                    }
                }
                else if(month==2)
                {
                    if(year%4==0&&year%100!=0)
                    {
                        if(day==30)
                        {
                            month++;
                            day=1;
                        }
                    }
                    else if(year%400==0)
                    {
                        if(day==30)
                        {
                            month++;
                            day=1;
                        }
                    }
                    else {
                        if(day==29)
                        {
                            month++;
                            day=1;
                        }
                    }
                }
                else if(month==12&&day==32)
                {
                    year++;
                    month=1;
                    day=1;

                }
            }
        }
        //return ad(date1)-ad(date2);
    }
//    public static int ad(MyDate date)
//    {
//        int year=1800;
//        int month=1;
//        int day=1;
//        int t=0;
//        while(true)
//        {
//            if(year==date.year&&month==date.month&&day==date.day)
//            {
//                return t;
//            }
//            t++;
//            day++;
//            if(month==1||month==3||month==5||month==7||month==8||month==10)
//            {
//                if(day==32)
//                {
//                    month++;
//                    day=1;
//                }
//            }
//            else if(month==4||month==6||month==9||month==11)
//            {
//                if(day==31)
//                {
//                    month++;
//                    day=1;
//                }
//            }
//            else if(month==2)
//            {
//                if(year%4==0&&year%100!=0)
//                {
//                    if(day==30)
//                    {
//                        month++;
//                        day=1;
//                    }
//                }
//                else if(year%400==0)
//                {
//                    if(day==30)
//                    {
//                        month++;
//                        day=1;
//                    }
//                }
//                else {
//                    if(day==29)
//                    {
//                        month++;
//                        day=1;
//                    }
//                }
//            }
//            else if(month==12&&day==32)
//            {
//                year++;
//                month=1;
//                day=1;
//            }
//        }
//    }
}