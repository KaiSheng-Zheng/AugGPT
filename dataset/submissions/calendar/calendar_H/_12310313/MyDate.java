public class MyDate {
    int year;
    int month;
    int day;
    String event;

    static int []yuefen={31,28,31,30,31,30,31,31,30,31,30,31};
    static int []yuefen2={31,29,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year,int month,int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public void addDays(int day) {
        this.day += day;
        if ((year%4==0&&year%100!=0)||year%400==0) {
            while(0==0){
                if (this.day>yuefen2[month-1]) {
                    this.day-=yuefen2[month-1];
                    month+=1;
                    if(month==13){
                        month=1;
                        year+=1;
                    }
                }else{break;}
            }
        }else{
            while(0==0){
                if (this.day>yuefen[month-1]) {
                    this.day-=yuefen[month-1];
                    month+=1;
                    if(month==13){
                        month=1;
                        year+=1;
                    }
                }else{break;}
            }
        }
    }
    public String toString(){
        String str=String.format("%04d-%02d-%02d",year,month,day);
        return str;
    }

    public static int sum(MyDate day){
        int d=0;
        int[] x={0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<day.year;i++){
            if(i%4==0&& i%100!=0 || i%400==0){
                d+=366;
            }else{
                d+=365;
            }
        }
        if(day.year%4==0&& day.year%100!=0 || day.year%400==0){
            x[2]=29;
        }
        for(int i=1;i<day.month;i++){

            d+=x[i];
        }
        d+=day.day;
        System.out.println(d);
        return d;

    }




    int uu=0;
    public static int difference(MyDate date1, MyDate date2){
        int a=0,b=0;
        int s1=sum(date1);
        int s2=sum(date2);
        if ((date1.year%4==0&&date1.year%100!=0)||date1.year%400==0) {
            a+=date1.year*3*365/4+date1.year*366/4;
            for (int i = 0; i < date1.month-1; i++) {
                a+=yuefen2[i];
            }
            a+=date1.day;
        }else{
            a+= (date1.year-date1.year%4)*(365*3+366)/4+date1.year%4*365;
            for (int i = 0; i < date1.month-1; i++) {
                a+=yuefen[i];
            }
            a+=date1.day;
        }
        if ((date2.year%4==0&&date2.year%100!=0)||date2.year%400==0) {
            b+=date2.year*3*365/4+date2.year*366/4;
            for (int i = 0; i < date2.month-1; i++) {
                b+=yuefen2[i];
            }
            b+=date2.day;
        }else{
            b+= (date2.year-date2.year%4)*(365*3+366)/4+date2.year%4*365;
            for (int i = 0; i < date2.month-1; i++) {
                b+=yuefen[i];
            }
            b+=date2.day;
        }
        return s1-s2;
    }
}

