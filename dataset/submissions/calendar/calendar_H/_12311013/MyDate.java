
import java.util.ArrayList;

public class MyDate {

    private int year;
    private int month;
    private int day;
    private static int[] mons={31,28,31,30,31,30,31,31,30,31,30,31};
    ArrayList<String> event=new ArrayList<>();

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public void addDays(int days){
        if((year%4==0&&year%100!=0)||year%400==0){mons[1]=29;}else{mons[1]=28;}
        int cont=0;
        if(day+days<=mons[this.month-1]){
        day+=days;}else{
            int su=day+days;
            int suyue=month+cont;


            while(su>mons[(suyue-1)]){
                su=su-mons[suyue-1];
                cont+=1;
                suyue+=1;
                if(suyue>12){
                    year++;
                    if((year%4==0&&year%100!=0)||year%400==0){mons[1]=29;}else{mons[1]=28;}
                    suyue-=12;
                }
            }
            while(month+cont>12){
                cont-=12;
            }
            month+=cont;
            this.day=su;

        }
    }

    public String toString(){
        if(month>=10){
            if(day>=10){
        return year+"-"+month+"-"+day;}else{return year+"-"+month+"-"+"0"+day;}}
        else{if(day>=10){
            return year+"-"+"0"+month+"-"+day;}else{return year+"-"+"0"+month+"-"+"0"+day;}}
    }
    public static int difference(MyDate date1, MyDate date2){
        mons[1]=28;
        int D1=0;
        int D2=0;
        for (int i = 1582; i < date1.year; i++) {
            if((i%4==0&&i%100!=0)||i%400==0){
                D1+=366;
            }else{D1+=365;}
        }
        for (int i = 0; i < date1.month-1; i++) {
            D1+=mons[i];
        }
        D1+=date1.day;
        if(date1.month>2&&((date1.year%4==0&&date1.year%100!=0)|| date1.year%400==0)){
            D1+=1;
        }

        for (int i = 1582; i < date2.year; i++) {
            if((i%4==0&&i%100!=0)||i%400==0){
                D2+=366;
            }else{D2+=365;}
        }
        for (int i = 0; i < date2.month-1; i++) {
            D2+=mons[i];
        }
        D2+=date2.day;
        if(date2.month>2&&((date2.year%4==0&&date2.year%100!=0)|| date2.year%400==0)){
            D2+=1;
        }
        return D1-D2;
    }
    void paixv(){
        for (int i = 0; i < event.size(); i++) {
            for (int j = 0; j < event.size()-1; j++) {
                String ti;
                if(event.get(j).compareTo(event.get(j+1))>0){
                    ti=event.get(j+1);
                    event.set(j+1,event.get(j));
                    event.set(j,ti);
                }
            }
        }
    }

}
