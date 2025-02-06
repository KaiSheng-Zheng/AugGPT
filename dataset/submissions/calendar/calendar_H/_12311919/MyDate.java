import java.util.ArrayList;

public class MyDate {
    private int year;
    private int month;
    private int day;
    static int numbers=0;
    private   int sequence;
    private ArrayList<String>e=new ArrayList<>(10);
    public int getSequence(){
        return sequence;}
    public static int getNumbers(){
        return numbers;
    }
    public  int getMonth(){
        return month;
    }

    public int getDay() {
        return day;
    }

    public MyDate(int year, int month, int day){
        this.day=day;
        this.year=year;
        this.month=month;
        sequence=getNumbers();
        numbers++;
    }
    public void addDays(int days){
        day+=days;
        boolean b=false;
        while (!b){
        if((year%4==0&&year%100!=0)||(year%400==0)){
            if(month==1|month==3|month==5|month==7|month==8|month==10){
                if(day>31){
                month++;
                day-=31;
                }
                if(month==1){
                    b=day<=29;
                }
                if(month==7){
                    b=day<=31;
                }
                if(month==3|month==5|month==8|month==10){
                    b=day<=31;
                }
            }
            if(month==12){
                if(day>31){
                    month=1;
                    day-=31;
                    year++;
                }
                b=day<=31;
            }
            if(month==2){
                if(day>29){
                    month++;
                    day-=29;
                }
                b=day<=31;
            }
        }else {
            if(month==1|month==3|month==5|month==7|month==8|month==10){
                if(day>31){
                    month++;
                    day-=31;}
                if(month==1)b=day<=28;
                if(month==7)b=day<=31;
                if(month==3|month==5|month==8|month==10)b=day<=30;
            }
            if(month==12){
                if(day>31){
                    month=1;
                    day-=31;
                    year++;
                }
                b=day<=31;
            }
            if(month==2){
                if(day>28){
                    month++;
                    day-=28;
                }
                b=day<=31;
            }
        }
            if(month==4|month==6|month==9|month==11){
                if(day>30){
                    month++;
                    day-=30;
                }
                b=day<=31;
            }
        }
    }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    private int todays(){
        int d=month,a=1,c = 0;
        if(d>1){
          while(a<d){
            if(a==1|a==3|a==5|a==7|a==8|a==10|a==12){
                c+=31;
            }
            if(a==2){
                if((year%4==0&&year%100!=0)||(year%400==0)){
                    c+=29;
                }
                else c+=28;
            }
            if(a==4|a==6|a==9|a==11){
                c+=30;
            }
            a++;}
        }
        c+=day;
        return c;
    }
    public int getYear(){
        return year;
    }
    private int toyear(MyDate date1,MyDate date2){
        int big=Math.max(date1.getYear(),date2.getYear());
        int small=Math.min(date1.getYear(),date2.getYear());
        int c=0;
        if(big!=small){
            for (int i = small; i <big ; i++) {
                if((i%4==0&&i%100!=0)||(i%400==0)){
                    c+=366;
                }else c+=365;
            }
        }
        if(date1.getYear()<date2.getYear()) c*=-1;
        return c;
    }
    public static int difference(MyDate date1, MyDate date2){
        int difference,d1,d2,d3;
        d1=date1.todays();
        d2=date2.todays();
        d3= date1.toyear(date1,date2);
        difference=d3+d1-d2;
        return difference;
    }

    public ArrayList<String> getE() {
        return e;
    }

    public void setE(ArrayList<String> e) {
        this.e = e;
    }
    public int datenumber(){
        int a=getYear()*10000+getMonth()*100+getDay();
        return a;
    }
}
