public class MyDate {
    private int year;
    private int month;
    private int day;
    private int pureday;
    private static int[] yeardays=new int[10001];
    private static int[] md={0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static int[] monthdays=new int[13];
    private static int[] t_month=new int[13];

    private static void get_yearmonthdays(){
        int temp=0;
        for(int i=1581;i<=10000;i++) {
            if((i%4==0&&i%100!=0)||i%400==0){
                temp+=366;
            }
            else temp+=365;
            yeardays[i]=temp;
        }
        monthdays[1]=md[1];
        t_month[1]=md[1];
        for(int i=2;i<=12;i++){
            monthdays[i]=monthdays[i-1]+md[i];
            t_month[i]=t_month[i-1]+md[i];
            if(i==2)t_month[i]+=1;
        }

    }

    public MyDate(int year,int month,int day){
        if(yeardays[1582]==0)get_yearmonthdays();
        this.year=year;
        this.month=month;
        this.day=day;
        this.pureday=pure(year,month,day);

    }
    private int pure(int ny,int nm,int nd){
        int temp=0;
        if(((ny%4==0&&ny%100!=0)||ny%400==0))temp+=yeardays[ny-1]+t_month[nm-1]+nd;
        else temp+=yeardays[ny-1]+monthdays[nm-1]+nd;
        return temp;
    }
    private void refresh(){
        int temp=pureday;
        for(int i=1581;i<10000;i++){
            if(temp>yeardays[i]&&temp<=yeardays[i+1]){
                temp-=yeardays[i];
                year=i+1;
            }
        }
        if((year%4==0&&year%100!=0)||year%400==0){
            for(int i=0;i<=11;i++)
            {
                if(temp>t_month[i]&&temp<=t_month[i+1]){
                    temp-=t_month[i];
                    month=i+1;
                    day=temp;
                    return;
                }
            }
        }
        else {
            for(int i=0;i<=11;i++){
                if(temp>monthdays[i]&&temp<=monthdays[i+1]){
                    temp-=monthdays[i];
                    month=i+1;
                    day=temp;
                    return;
                }
            }
        }
    }
    public void addDays(int days){
        pureday+=days;
        refresh();
    }
    public String toString(){
        String t_month=""+month;
        String t_day=""+day;
        if(month<10)
            t_month="0"+t_month;
        if(day<10)
            t_day="0"+t_day;
        return year+"-"+t_month+"-"+t_day;
    }
    public  int getPureday(){
        return pureday;
    }
    public static int difference(MyDate date1, MyDate date2){
        return date1.pureday-date2.pureday;
    }


}
