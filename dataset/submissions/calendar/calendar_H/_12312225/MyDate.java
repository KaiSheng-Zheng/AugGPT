import java.time.LocalDate;
import java.util.ArrayList;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days)
    {
        for(int i=1;i<=days;i++)
        {
            if(this.month==1||this.month==3||this.month==5||
                    this.month==7||this.month==8||
                    this.month==10||this.month==12)
            {
                if(this.day==31)
                {
                    this.day=1;
                    this.month++;
                    if(this.month==13)
                    {
                        this.month=1;
                        this.year++;
                    }
                }
                else
                {
                    this.day++;
                }
            }
            else if(this.month==2)
            {
                if(this.year%400==0||this.year%4==0&&this.year%100!=0)
                {
                    if(this.day==29)
                    {
                        this.day=1;
                        this.month++;
                    }
                    else
                    {
                        this.day++;
                    }
                }
                else
                {
                    if(this.day==28)
                    {
                        this.day=1;
                        this.month++;
                    }
                    else
                    {
                        this.day++;
                    }
                }
            }
            else
            {
                if(this.day==30)
                {
                    this.day=1;
                    this.month++;
                }
                else
                {
                    this.day++;
                }
            }
        }
    }
    public String toString()
    {
        return String.format("%d-%02d-%02d",this.year,this.month,this.day);
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        LocalDate f1=LocalDate.of(date1.year,date1.month,date1.day);
        LocalDate f2=LocalDate.of(date2.year,date2.month,date2.day);
        return (int)(f1.toEpochDay()-f2.toEpochDay());
    }

    ArrayList<String> eventName=new ArrayList<String>();
    public void addEventName(String eventName) {
        this.eventName.add(eventName);
    }

}