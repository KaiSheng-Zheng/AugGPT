

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days){
        for (int i = 0; i < days; i++) {
            day++;
            if ((month<=7&&month%2==1)||(month>=8&&month%2==0)){
                if (day==32){day=1;month++;}
            } else if (month==2){
                if ((year%4==0&&year%100!=0)||year%400==0){if (day==30){day=1;month++;}}
               else{if (day==29){day=1;month++;} }
            } else{ if(day==31){day=1;month++;}}
            if(month==13){month=1;year++;}
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        int n1=365* (date1.year-1)+ (date1.year-1)/4- (date1.year-1)/100+ (date1.year-1)/400;
        int n2=365* (date2.year-1)+ (date2.year-1)/4- (date2.year-1)/100+(date2.year-1)/400;
        int n11=0;int n22=0;
        for (int i = 1; i <date1.month ; i++) {
            if ((i<=7&&i%2==1)||(i>=8&&i%2==0)){n11+=31;}
            else if(i==2){if ((date1.year%4==0&&date1.year%100!=0)||date1.year%400==0){n11+=29;}
            else{n11+=28; }}
            else{n11+=30;}
        }
        for (int i = 1; i <date2.month ; i++) {
            if ((i<=7&&i%2==1)||(i>=8&&i%2==0)){n22+=31;}
            else if(i==2){if ((date2.year%4==0&&date2.year%100!=0)|| date2.year%400==0){n22+=29;}
            else{n22+=28; }}
            else{n22+=30;}
        }
        return n11+n1+ date1.day-n22-n2- date2.day;
    }



}


