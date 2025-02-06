public class MyDate{
    private int year;
    private int month;
    private int day;
    private int MonthDay;
    private int YearDay;
    private int DayHavePasted;
    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        getDayHavePasted();
        getYearDay(year);
        getMonthDay(month);
    }
    public void getDayHavePasted()
    {
        DayHavePasted =0;
        for(int i =1;i<month;i++){
            DayHavePasted+=getMonthDay(i);
        }
        DayHavePasted+=day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getMonthDay() {
        return MonthDay;
    }

    public int getYearDay() {
        return YearDay;
    }

    void getYearDay(int year)
    {
        YearDay =  year%400==0||year%4==0&&year%100!=0?366:365;
    }
    private final int[]Big = new int[]{1,3,5,7,8,10,12};
    private final int[]Small = new int[]{4,6,9,11};
    public int getMonthDay(int month)
    {
        for (int j : Big)
        {
            if (month == j) {
                MonthDay = 31;
                break;
            }
        }
        for (int j : Small)
        {
            if (month == j) {
                MonthDay = 30;
                break;
            }
        }
        if(month == 2) {
            MonthDay = year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? 29 : 28;
        }
        return MonthDay;
    }
    public void addDays(int days)
    {
        getDayHavePasted();
        getMonthDay(month);
        day+=days;
        if(days+DayHavePasted<=YearDay)
        {
            while(day>MonthDay)
            {
                day-=MonthDay;
                month++;
                getMonthDay(month);
            }
        }
        if(days+DayHavePasted>YearDay)
        {
            day=days-(YearDay-DayHavePasted);
            year++;
            getYearDay(year);
            month =1;
            getMonthDay(month);
            if (day > YearDay) {
                while (day > YearDay) {
                    day -= YearDay;
                    year++;
                    getYearDay(year);
                }
                month = 1;
                getMonthDay(month);

            }
            while(day>MonthDay)
            {
                day-=MonthDay;
                month++;
                getMonthDay(month);
            }
        }
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        int a = 0;
        int monthT1 = 0;
        int monthT2 = 0;
        int year = 0;
        for(int i =1;i<date1.month;i++){
            date1.getMonthDay(i);
            monthT1+=date1.MonthDay;
        }
        for(int i =1;i<date2.month;i++){
            date2.getMonthDay(i);
            monthT2+=date2.MonthDay;
        }
        if(date1.year>=date2.year)
        {
            for(int i =0;i<date1.year-date2.year;i++)
            {
                date2.getYearDay(date2.year+i);
                year+=date2.YearDay;
            }
        }
        else
        {
            for(int i =0;i<date2.year-date1.year;i++)
            {
                date1.getYearDay(date1.year+i);
                year-=date1.YearDay;
            }
        }
        a = monthT1-monthT2+date1.day-date2.day+year;
        return a;
    }
    @Override
    public String toString()
    {
        int a = year;
        String e;
        int b = month;
        String d;
        if(b<=9&&b>0){d = "0"+b;}
        else{d = String.valueOf(b);}
        int c = day;
        if(c<=9&&c>0){e = "0"+c;}
        else{e = String.valueOf(c);}
        return String.format("%s-%s-%s",a,d,e);
    }
}