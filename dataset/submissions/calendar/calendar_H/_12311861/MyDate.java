class MyDate{
    private int year;
    private int month;
    private int day;
    private String nam;
    public MyDate(int yea,int mont,int da){
        year=yea;
        month=mont;
        day=da;
    }
    public void setNam(String name) {
        nam=name;
    }
    public String getNam(){
        return nam;
    }
    private static int[] mon= new int[]{0, 31,28,31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] monsum= new int[]{0,31,59,90,120,151,181,212,243,273,304,334,365};
    public   int tonum(){
        int sum=day;
        sum+=monsum[month-1];
        if((year%4==0&&year%100!=0)||year%400==0){
            if(month-1>=2) sum+=1;
        }
        int yea=year-1;
        sum+=(yea/400)*146097+((yea%400)/100)*36524+((yea%100)/4)*1461+(yea%4)*365;
        return sum;
    }
    public void addDays(int days){
        days+=this.tonum();
        year=(days/146097)*400;days-=(year/400)*146097;
        int ad=days/36524;days-=ad*36524;year+=ad*100;
        ad=days/1461;days-=ad*1461;year+=ad*4;
        year+=1;
        ad=days/365;
        days-=ad*365;year+=ad;
        if(days==0){
            year-=1;
            month=12;day=31;
            return;
        }
        month=1;day=1;
        int yyy=0;
        if((year%4==0&&year%100!=0)||year%400==0){
            if(days<366) yyy=1;
        }
        for(int i=1;i<=12;i++){
            if(month==2&&yyy==1){
                if(days>29){
                    month+=1;
                    days-=29;
                    continue;
                }else{
                    break;
                }
            }
            if(days>mon[month]){
                days-=mon[month];
                month+=1;
                if(month>12){
                    month=1;year+=1;
                }
            }else{
                break;
            }
        }
        day=days;
    }
    public String toString(){
        StringBuilder ou= new StringBuilder(100);
        ou.append(year);ou.append("-");
        if(month<10){
            ou.append("0");
        }
        ou.append(month);ou.append("-");
        if(day<10){
            ou.append("0");
        }
        ou.append(day);
        return ou.toString();
    }
    public static int difference(MyDate date1, MyDate date2){
        return date1.tonum()-date2.tonum();
    }
}