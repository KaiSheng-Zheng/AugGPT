import java.util.ArrayList;

public class MyCalendar {
    private ArrayList<String> calender;
    private ArrayList<MyDate> dates;

    private int capacity;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.calender=new ArrayList<>();
        this.dates=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if(capacity>calender.size()){
        calender.add(eventName);
        dates.add(date);
        return true;}
        else{return false;}
    }
    public String finishNextEvent(){
        for(int i=0;i<dates.size();i++){
            for(int j=0;j<dates.size()-1;j++){
                if(MyDate.difference(dates.get(j),dates.get(j+1))>0){
                    MyDate date1=dates.get(j);
                    dates.set(j,dates.get(j+1));
                    dates.set(j+1,date1);
                    String a=calender.get(j);
                    calender.set(j,calender.get(j+1));
                    calender.set(j+1,a);
            }
        }
        }
        for(int i=0;i<dates.size();i++){
            for(int j=0;j<dates.size()-1;j++){
                if(MyDate.difference(dates.get(j),dates.get(j+1))==0){
                    if(calender.get(j).compareTo(calender.get(j+1))>0) {
                        String a=calender.get(j);
                        calender.set(j,calender.get(j+1));
                        calender.set(j+1,a);
                    }
                }
            }
}
        if(dates.size()>0){
            String a=calender.get(0);
            dates.remove(0);
            calender.remove(0);
        return a;
        }
        else{return "NONE";}
    }
}