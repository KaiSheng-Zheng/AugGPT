import java.util.ArrayList;
public class MyCalendar {
    ArrayList<MyDate> Dates=new ArrayList<>();
    ArrayList<String> Events=new ArrayList<>();
    private int n;
    private int m;
    public MyCalendar(int capacity) {
        n=capacity;
        m=0;
    }

    public String toString() {
        return "MyCalender{}";
    }
    public boolean addEvent(MyDate date, String eventName){
        m+=1;
        if(m>n){
            return (m<=n);
        }
        if(Dates.size()==0){
            Dates.add(date);
            Events.add(eventName);
        }
        else{
            int a=Dates.size();
            for(int i=0;i<a;i++){
                if(MyDate.difference(date,Dates.get(i))<0){
                    Dates.add(i,date);
                    Events.add(i,eventName);
                    break;
                }
                else if(MyDate.difference(date,Dates.get(i))==0){
                    int x=eventName.compareTo(Events.get(i));
                    if(x<0){
                        Dates.add(i,date);
                        Events.add(i,eventName);
                        break;
                    }
                }
                if(i==(Dates.size()-1)){
                    Dates.add(date);
                    Events.add(eventName);
                }
            }
        }
        return (m<=n);
    }
    public String finishNextEvent(){
        if(Events.size()==0){
            return "NONE";
        }
        String tempName=new String();
        tempName=Events.get(0);
        Dates.remove(0);
        Events.remove(0);
        return tempName;
    }

}