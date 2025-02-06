public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
        if(days>daynum(month,year)-day){
            days=days-(daynum(month,year)-day)-1;
            month++;
            day=1;
        }
        else {
            day=day+days;
            return;
        }
        while(days>daynum(month%12,year)-1){
            days-=daynum(month%12,year);
            month++;
            if(month==13){
                month=1;year++;
            }
        }
        day=day+days;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        MyDate temp;
        int ans=0,i,flag;
        if(compare(date1,date2)){
            flag=-1;
        }
        else {
            flag=1;
            temp=date1;date1=date2;date2=temp;
        }
        if(date1.year==date2.year)
        {
            if(date1.month==date2.month)
                ans=date2.day-date1.day;
            else {
                for(i=date1.month+1;i<=date2.month-1;i++)
                {
                    ans+=daynum(i,date1.year);
                }
                ans=ans+daynum(date1.month,date1.year)-date1.day+date2.day;
            }
            return ans*flag;
        }
        ans=(date2.year-date1.year-1)*365;
        for(i=date1.year+1;i<=date2.year-1;i++)
        {
            if(check(i))
                ans++;
        }
        ans=Math.max(0,ans);
        for(i=date1.month+1;i<=12;i++)
        {
            ans+=daynum(i,date1.year);
        }
        for(i=1;i<=date2.month-1;i++)
        {
            ans+=daynum(i,date2.year);
        }
        ans=ans+daynum(date1.month,date1.year)-date1.day+date2.day;
        return ans*flag;
    }

    public static boolean check(int year){
        if(year%400==0||(year%4==0&&year%100!=0))
            return true;
        else return false;
    }
    public static int daynum(int month,int year)
    {
        int[] num={31,31,28,31,30,31,30,31,31,30,31,30,31};
        if(month==2){
            if(check(year))
                return 29;
            else return 28;
        }
        else return num[month];
    }
    public static boolean compare(MyDate date1,MyDate date2){
        if(date1.year<date2.year)
            return true;
        else if(date1.year>date2.year)
            return false;
        else if(date1.month<date2.month)
            return true;
        else if(date1.month>date2.month)
            return false;
        else if(date1.day<date2.day)
            return true;
        else return false;
    }
}