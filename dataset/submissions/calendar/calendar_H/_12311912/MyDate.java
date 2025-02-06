public class MyDate
{
    private int year;
    private int month;
    private int day;
    private final int[][] d = { {365,31,28,31,30,31,30,31,31,30,31,30,31},
            {366,31,29,31,30,31,30,31,31,30,31,30,31}};
    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days)
    {
        while (days-- > 0)
        {
            if (this.day + 1 > d[ifrun()][this.month])
            {
                this.day = 1;
                if (this.month + 1 > 12)
                {
                    this.month = 1;
                    this.year++;
                }
                else this.month++;
            }
            else this.day++;
        }
    }
    public int ifrun()
    {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? 1 : 0;
    }
    public String toString()
    {
        return (year + "-" + (month < 10 ? ("0" + month) : (month)) + "-" + (day < 10 ? ("0" + day) : (day)));
    }
    public static boolean bigger(MyDate date1, MyDate date2)
    {
        if (date1.year > date2.year) return true;
        else if (date1.year == date2.year)
        {
            if (date1.month > date2.month) return true;
            else if (date1.month == date2.month)
            {
                if (date1.day > date2.day) return true;
                else return false;
            }
            else return false;
        }
        return false;
    }
    public static boolean thesame(MyDate a, MyDate b)
    {
        return (a.year == b.year && a.month == b.month && a.day == b.day);
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        if (thesame(date1,date2)) return 0;
        if (bigger(date1,date2))
        {
            int count = 0;
            for (MyDate date = new MyDate(date2.year,date2.month,date2.day);!thesame(date,date1);date.addDays(1))
            {
                count++;
            }
            return count;
        }
        else return -difference(date2,date1);
    }
}
