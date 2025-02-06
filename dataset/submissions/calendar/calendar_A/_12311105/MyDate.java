public class MyDate{
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days) {
        int n=days+day;
        while (n>daysOfMonth(month,isLeapYear(year))) {            
            n-=daysOfMonth(month,isLeapYear(year));
            month++;
            if(month==13){
                month=1;year++;
            }
        }
        day=n;
    }
    public String toString(){
        String m=String.valueOf(month);
        String d=String.valueOf(day);
        if(month<=9){
            m="0"+String.valueOf(month);
        }if(day<=9){
            d="0"+String.valueOf(day);
        }
        return String.format("%d-%s-%s",year,m,d);
    }
    public static int difference(MyDate date1,MyDate date2){
        int num=0;
        if((date1.year<date2.year)||(date1.year==date2.year&&date1.month<date2.month)||(date1.year==date2.year&&date1.month==date2.month&&date1.day<date2.day)){
            for(int a=date1.year;a<=date2.year;a++){
                if(isLeapYear(a)){
                    num+=366;
                }else {
                    num+=365;
                }
            }int num1=0;
            for(int i=1;i<date1.month;i++){
                num1+=daysOfMonth(i,isLeapYear(date1.year));
            }int num2=0;
            for(int i=date2.month+1;i<=12;i++){
                num2+=daysOfMonth(i,isLeapYear(date2.year));
            }num=num-num1-num2-date1.day-(daysOfMonth(date2.month,isLeapYear(date2.year))-date2.day);
            return -num;
        }else {
            for(int a=date2.year;a<=date1.year;a++){
                if(isLeapYear(a)){
                    num+=366;
                }else {
                    num+=365;
                }
            }int num1=0;
            for(int i=1;i<date2.month;i++){
                num1+=daysOfMonth(i,isLeapYear(date2.year));
            }int num2=0;
            for(int i=date1.month+1;i<=12;i++){
                num2+=daysOfMonth(i,isLeapYear(date1.year));
            }num=num-num1-num2-date2.day-(daysOfMonth(date1.month,isLeapYear(date1.year))-date1.day);
            return num;
        }

    }
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static int daysOfMonth(int month,boolean isLeapYear){
        int n=0;
        switch (month){
            case 1:n= 31;break;
            case 2:
                if(isLeapYear){
                    n= 29;
                }else {
                    n= 28;
                }break;
            case 3:n= 31;break;
            case 4:n= 30;break;
            case 5:n= 31;break;
            case 6:n= 30;break;
            case 7:n= 31;break;
            case 8:n=31;break;
            case 9:n= 30;break;
            case 10:n=31;break;
            case 11:n= 30;break;
            case 12:n=31;break;
        }
        return n;
    }
}