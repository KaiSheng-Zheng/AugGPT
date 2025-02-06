
import java.util.ArrayList;
import java.util.Objects;

public class MyCalendar {
    private  ArrayList<MyDate> dates=new ArrayList<>();
    private  ArrayList<String> events=new ArrayList<>();
    private int capacity;

    int cap=0;
//    String daiding="";
    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }
    private int count=0;
    public boolean addEvent(MyDate date, String eventName){

        if(cap>=capacity){
            return false;
        }else{
            dates.add(date);
            events.add(eventName);
            cap++;
            for (int i = count; i < dates.size(); i++) {
                for (int j = count; j < dates.size()-1; j++) {
                    if(MyDate.difference(dates.get(j),dates.get(j+1))>0){
                        MyDate ate;
                        String str;
                        ate=dates.get(j);
                        dates.set(j,dates.get(j+1));
                        dates.set(j+1,ate);
                        str= events.get(j);
                        events.set(j,events.get(j+1));
                        events.set(j+1,str);
                    }else if(MyDate.difference(dates.get(j),dates.get(j+1))==0){
                        if(events.get(j).compareTo(events.get(j+1))>0){
                            MyDate ate;
                            String str;
                            ate=dates.get(j);
                            dates.set(j,dates.get(j+1));
                            dates.set(j+1,ate);
                            str= events.get(j);
                            events.set(j,events.get(j+1));
                            events.set(j+1,str);
                        }
                    }
                }
            }

//            date.event.add(eventName);
//            cap++;
//            date.paixv();
//            if(dates.size()==0){dates.add(date);}
//            step:{
//            for (int i = 0; i < dates.size(); i++) {
//                if(dates.get(i)==date){break step;}}
//            dates.add(date);}
            return true;
        }
    }

    public String finishNextEvent(){
//        if(count<=capacity){
//            MyDate da;
//            for (int i = 0; i < dates.size(); i++) {
//                for (int j = 0; j < dates.size()-1; j++) {
//                    if(MyDate.difference(dates.get(j),dates.get(j+1))>=0){
//                        da=dates.get(j+1);
//                        dates.set(j+1,dates.get(j));
//                        dates.set(j,da);
//                    }
//                }
//            }
//            int t=0;
//            int m=0;
//            for (int i = 0; i < dates.size(); i++) {
//                for (int j = 0; j < dates.get(i).event.size(); j++) {
//                    if(dates.get(i).event.get(j)=="finished"){m++;if(m==dates.get(i).event.size()-1){break;}}else{
//                    if(daiding.compareTo(dates.get(i).event.get(j))>0|| daiding.equals("")){
//                    daiding=dates.get(i).event.get(j);t=j;}}
//                }
//                dates.get(i).event.set(t,"finished");}
//               return daiding;

//            for (int i = 0; i < dates.size(); i++) {
//                for (int j = 0; j < ; j++) {
//                    if(dates.get(i).){
//                        daiding= }}
//            }

        if(count<=capacity-1&&count<=events.size()-1){
            String st=events.get(count);
            count++;
            capacity++;
            return st;
//            MyDate da;
//            for (int i = 0; i < dates.size(); i++) {
//                for (int j = 0; j < dates.size()-1; j++) {
//                    if(MyDate.difference(dates.get(j),dates.get(j+1))>=0){
//                        da=dates.get(j+1);
//                        dates.set(j+1,dates.get(j));
//                        dates.set(j,da);
//                    }
//                }
//            }
//            while(true){
//
//                String dat;
//                for (int i = 0; i < dates.size(); i++) {
//
//
//                    for (int j = 0; j < dates.get(i).event.size(); j++) {
//
//
//                        if(!Objects.equals(dates.get(i).event.get(j), "finished")){
//                            dat=dates.get(i).event.get(j);
//                            count++;
//                            dates.get(i).event.set(j,"finished");
//                            return dat;}}}return "NONE";}
        }else{
            return "NONE";
        }

    }

}
