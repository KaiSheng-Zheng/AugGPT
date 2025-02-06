public class MyDate
{
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day)
    {
        this.day=day;
        this.year=year;
        this.month=month;
    }

    public void addDays(int days)
    {
        day+=days;
        for(;day>dayInMonth(year,month);)
        {
            day-=dayInMonth(year,month);
            month++;
            if(month>12)
            {
                month%=13;
                year++;
            }
//            System.out.printf("year=%d,month=%d,day=%d\n",year,month,day);
        }
//        System.out.printf("year=%d,month=%d,day=%d\n",year,month,day);
    }

    @Override
    public String toString()
    {
        return String.format("%04d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2)
    {
        int day1,day2;
        day1=toDays(date1);
        day2=toDays(date2);
//        System.out.printf("day1=%d,day2=%d\n",day1,day2);
        return day1-day2;
    }

    public static int dayInMonth(int year,int month)
    {
        int[] dayNotLeapYear={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] dayIsLeapYear={0,31,29,31,30,31,30,31,31,30,31,30,31};
        if((year%4==0&&year%100!=0)||year%400==0)//leap year
            return dayIsLeapYear[month];
        else
            return dayNotLeapYear[month];
    }

    public static int toDays(MyDate date)
    {
        int add=date.day;
        int year=date.year,month=date.month-1;
//        System.out.printf("add=%d\n",add);
        for(;month>0;month--)
            add+=dayInMonth(year,month);
//        System.out.printf("add=%d\n",add);
        year--;
        for(;year>1527;year--)
        {
            if((year%4==0&&year%100!=0)||year%400==0)//leap year
                add+=366;
            else
                add+=365;
        }
//        System.out.printf("add=%d\n",add);
//        System.out.printf("\n");
        return add;
    }
}