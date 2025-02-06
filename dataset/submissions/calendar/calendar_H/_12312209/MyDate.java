import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int count;
    private ArrayList<String> event=new ArrayList<>();
    public ArrayList<String> getEvent(){
        return event;
    }
    public int getcount(){
        return count;
    }
    public void setCount(int a){
        this.count=a;
    }
    public void addCount(){
        count++;
    }
    public void addEvent(String a){
        event.add(a);
    }
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void order() {
        String temp;
        for(int i = 0; i < event.size(); ++i) {
            for(int j = 0; j < event.size(); ++j) {
                if (event.get(i).compareTo(event.get(j))<0) {
                    temp = event.get(i);
                    event.set(i,event.get(j));
                    event.set(j,temp);
                }
            }
        }
    }
    public void addDays(int days){
        int Break=0;
        int count = days + day;
        if (days>0){
            while (Break==0){
                if(year%400==0||(year%4==0&&year%100!=0)){
                    switch (month){
                        case 2:
                            if (count<30){
                                Break++;
                            }else {
                                count = count-29;
                                month++;
                            }break;
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                            if (count<32){
                                Break++;
                            }else {
                                count = count-31;
                                month++;
                            }break;
                        case 12:
                            if (count<32) {
                                Break++;
                            }else {
                                count = count - 31;
                                month = 1;
                                year++;
                            }break;
                        default:
                            if (count<31){
                                Break++;
                            }else {
                                count = count-30;
                                month++;
                            }break;
                    }
                }else{
                    switch (month){
                        case 2:
                            if (count<29){
                                Break++;
                            }else {
                                count = count-28;
                                month++;
                            }break;
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                            if (count<32){
                                Break++;
                            }else {
                                count = count-31;
                                month++;
                            }break;
                        case 12:
                            if (count<32) {
                                Break++;
                            }else {
                                count = count - 31;
                                month = 1;
                                year++;
                            }break;
                        default:
                            if (count<31){
                                Break++;
                            }else {
                                count = count-30;
                                month++;
                            }break;
                    }
                }
            }
        }else {
            while (Break==0){
                if(year%400==0||(year%4==0&&year%100!=0)){
                    switch (month){
                        case 3:
                            if (count>0){
                                Break++;
                            }else {
                                count = count+29;
                                month--;
                            }break;
                        case 2:
                        case 4:
                        case 6:
                        case 8:
                        case 9:
                        case 11:
                            if (count>0){
                                Break++;
                            }else {
                                count = count+31;
                                month--;
                            }break;
                        case 1:
                            if (count>0){
                                Break++;
                            }else {
                                count=count+31;
                                month=12;
                                year--;
                            }
                        default:
                            if (count>0){
                                Break++;
                            }else {
                                count = count+30;
                                month--;
                            }break;
                    }
                }else{
                    switch (month){
                        case 3:
                            if (count>0){
                                Break++;
                            }else {
                                count = count+28;
                                month--;
                            }break;
                        case 2:
                        case 4:
                        case 6:
                        case 8:
                        case 9:
                        case 11:
                            if (count>0){
                                Break++;
                            }else {
                                count = count+31;
                                month--;
                            }break;
                        case 1:
                            if (count>0){
                                Break++;
                            }else {
                                count=count+31;
                                month=12;
                                year--;
                            }
                        default:
                            if (count>0){
                                Break++;
                            }else {
                                count = count+30;
                                month--;
                            }break;
                    }
                }
            }
        }day = count;
    }
    public String toString(){
        if (day<10&&month<10){
            return year + "-0" + month + "-0" + day;
        } else if (day<10) {
            return year + "-" + month + "-0" + day;
        } else if (month<10) {
            return year + "-0" + month + "-" + day;
        }else {
            return year + "-" + month + "-" + day;
        }
    }
    public static int difference(MyDate date1, MyDate date2){
        int i = 0;
        if (date1.year>date2.year||(date1.year==date2.year&&date1.month>date2.month)||(date1.year==date2.year&&date1.month==date2.month&&date1.day>date2.day)) {
            while  (date1.year> date2.year||(date1.year== date2.year&& date1.month> date2.month)||(date1.year== date2.year&& date1.month== date2.month&& date1.day> date2.day)) {
                date1.addDays(-1);
                i++;

            }
            date1.addDays(i);
            return i;
        }else {
            while(date1.year< date2.year||(date1.year== date2.year&& date1.month< date2.month)||(date1.year== date2.year&& date1.month== date2.month&& date1.day< date2.day)){
                date1.addDays(1);
                i++;
            }
            date1.addDays(-i);
            return -i;
        }
    }
}
