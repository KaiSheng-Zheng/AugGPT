public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public void addDays(int days){
        int a=transferDateToDays(year, month, day);
        a+=days;
        int b=year;
        month=transferDaysToDate(a).month;
        day=transferDaysToDate(a).day;
        year=transferDaysToDate(a).year;
    }
    public int transferDateToDays(int year,int month,int day){
        int Days=0;
        switch(month){
            case 2:
                Days+=31;
                break;
            case 3:
                Days+=59;
                break;
            case 4:
                Days+=90;
                break;
            case 5:
                Days+=120;
                break;
            case 6:
                Days+=151;
                break;
            case 7:
                Days+=181;
                break;
            case 8:
                Days+=212;
                break;
            case 9:
                Days+=243;
                break;
            case 10:
                Days+=273;
                break;
            case 11:
                Days+=304;
                break;
            case 12:
                Days+=334;
                break;
        }
        Days+=day;
        if(ifYearIsRunnian(year) && month>=3){
            Days+=1;
        }
        return Days;
    }
    public MyDate transferDaysToDate(int days){
        int a=year;
        int b=1;
        int c=1;
        int d=days;
        int[] daysOfMonth={31,28,31,30,31,30,31,31,30,31,30,31};
        for(;;){
            if(ifYearIsRunnian(a)){
                d-=366;
                if(d>=0){
                    a+=1;
                    days-=366;
                }
                else{
                    break;
                }
            }
            else{
                d-=365;
                if(d>=0){
                    a+=1;
                    days-=365;
                }
                else{
                    break;
                }
            }

        }
        System.out.println(days);
        if(ifYearIsRunnian(a)){
            daysOfMonth[1]+=1;
        }
        for(int i=0;i<=11;i++){
            days-=daysOfMonth[i];
            if(days<0){
                b=i+1;
                c=days+daysOfMonth[i];
                break;
            }
            if(days==0){
                b=i+1;
                c=daysOfMonth[i];
                break;
            }
            if(i==11 && days==0){
                a+=1;
            }
        }
        MyDate date=new MyDate(a,b,c);
        return date;

    }
    public  static boolean ifYearIsRunnian(int year){
        int a=year%4;
        int b=year%100;
        int c=year%400;
        return((a==0 && b!=0) || c==0);
    }
    public static int difference(MyDate date1, MyDate date2){
        int difference=0;
        int all=0;
        if(date1.year<date2.year){
            for(int i=date1.year;i<=date2.year;i++){
                if(MyDate.ifYearIsRunnian(i)){
                    all+=366;
                }
                else{
                    all+=365;
                }
            }
            if(MyDate.ifYearIsRunnian(date2.year)){
                difference=all- date1.transferDateToDays(date1.year, date1.month, date1.day)-366+date2.transferDateToDays(date2.year, date2.month, date2.day);
                difference=-difference;
            }
            else{
                difference=all- date1.transferDateToDays(date1.year, date1.month, date1.day)-365+date2.transferDateToDays(date2.year, date2.month, date2.day);
                difference=-difference;
            }
        }
        else if(date1.year>date2.year){
            for(int i=date2.year;i<=date1.year;i++){
                if(MyDate.ifYearIsRunnian(i)){
                    all+=366;
                }
                else{
                    all+=365;
                }
            }
            if(date1.ifYearIsRunnian(date1.year)){
                difference=all- date2.transferDateToDays(date2.year, date2.month, date2.day)-366+date1.transferDateToDays(date1.year, date1.month, date1.day);
            }
            else{
                difference=all- date2.transferDateToDays(date2.year, date2.month, date2.day)-365+date1.transferDateToDays(date1.year, date1.month, date1.day);
            }
        }
        else{
            difference=date1.transferDateToDays(date1.year, date1.month, date1.day)-date2.transferDateToDays(date2.year, date2.month, date2.day);
        }
        return difference;
    }
}