public class MyDate
{
    private int year;
    private int month;
    private int day;

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

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days)
    {
        if(days<=27)
        {
            if(getDay()+days>monthDays(getYear(),getMonth())&&getMonth()!=12)
            {
                setDay(getDay()+days-monthDays(getYear(),getMonth()));
                setMonth(getMonth()+1);
            }
            else if(getDay()+days>monthDays(getYear(),getMonth())&&getMonth()==12)
            {
                setDay(getDay()+days-monthDays(getYear(),getMonth()));
                setYear(getYear()+1);
                setMonth(1);
            }
            else
            {
                setDay(getDay()+days);
            }
        }
        else
        {
            addDays(27);
            addDays(days-27);
        }
    }
    public int monthDays(int year,int month)
    {
        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(yearDays(year)==366) return 29;
                else return 28;
        }
        return 0;
    }

    public int yearDays(int year)
    {
        if((year%4==0&&year%100!=0)||(year%400==0))
        {
           return 366;
        }
        else return 365;
    }

    public int countDays()
    {
        int sum=0;
        for(int i=0;i<= getYear()-1;i++) sum+=yearDays(i);
        for(int i=1;i<=getMonth()-1;i++) sum+=monthDays(getYear(), i);
        sum+= getDay();
        return sum;
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        return date1.countDays()-date2.countDays();
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d",getYear(),getMonth(),getDay());
    }
}
