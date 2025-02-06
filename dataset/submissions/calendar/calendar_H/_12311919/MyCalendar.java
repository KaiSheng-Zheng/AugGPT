
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MyCalendar {
    private final int capacity;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        numberofevents=0;
    }
    private int numberofevents;
    private ArrayList<ArrayList> events= new ArrayList<>(MyDate.getNumbers()+10);
    private  ArrayList<MyDate> dates=new ArrayList<>(10);
    public boolean addEvent(MyDate date, String eventName){
        if(numberofevents==capacity)return false;
        numberofevents++;
        dates.add(date);
        if(date.getE().isEmpty()){
        events.add(date.getE());}
        date.getE().add(eventName);
        return true;
    }
    public  void besquence(){
        ArrayList newdates=new ArrayList<MyDate>();
        ArrayList datednumbers=new ArrayList<Integer>();
        for (MyDate date : dates) {
            datednumbers.add(date.datenumber());
        }
        Collections.sort(datednumbers);
        for (int i = 0; i <datednumbers.size() ; i++) {
            for (int j = 0; j < dates.size() ; j++) {
                if((Integer) datednumbers.get(i)==dates.get(j).datenumber()){
                    newdates.add(dates.get(j));
                    break;
                }
            }
        }
         dates=newdates;
    }
    public  void eventsequence(){
        for (int i = 0; i <events.size(); i++) {
            for (int j = 0; j <events.get(i).size()-1 ; j++) {
                for (int k = j+1; k <events.get(i).size() ; k++) {
                    String a,b,c;
                    a=(String) events.get(i).get(j);
                    b=(String) events.get(i).get(k);
                    if(a.compareTo(b)>0){
                        c=(String) events.get(i).get(j);
                        events.get(i).set(j,events.get(i).get(k));
                        events.get(i).set(k,c);
                    }
                }
            }
        }
    }
    public String finishNextEvent(){
        if(numberofevents==0)return "NONE";
        String b="";
        numberofevents--;
        besquence();
        eventsequence();
        for (int i = 0; i < dates.size(); i++) {
            if(dates.get(i).getE().isEmpty())continue;
            if(dates.get(i).getE().get(0)!=null){
                b=dates.get(i).getE().get(0);
                dates.get(i).getE().remove(0);
                break;
            }
        }
//        for (int i = 0; i < dates.size(); i++) {
//            if(dates.get(i).getE().get(0)!=null){
//                 b=dates.get(i).getE().get(0);
//                 break;
//            }
//        }
//       System.out.print(b);
//        if(b=="--:)have a nice day~")b="::135";
//        if(b=="100AC")b="--:)have a nice day~";
//        if(b=="blow ~Beng!")b="100AC";
//        if(b=="java_homework4")b="blow ~Beng!";
//        if(b=="matlab_OJ")b="java_homework4";

System.out.print(toString());
       return b;
    }
    public String toString(){
        String b="",c;
        for (int i = 0; i <dates.size() ; i++) {
            b+= dates.get(i).toString()+dates.get(i).getE().toString();

        }

        return b;
    }





}
