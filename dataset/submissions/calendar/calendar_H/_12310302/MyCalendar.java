import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    ArrayList<MyDate> now =new ArrayList<>();
    public MyCalendar(int capa){
        this.capacity=capa;
    }
    public boolean addEvent(MyDate date, String eventName){
        //System.out.println(date.getYear(date)+" "+date.getMonth(date)+" "+date.getDay(date));
        MyDate dd =new MyDate(date.getYear(date),date.getMonth(date),date.getDay(date));
        if(this.now.size()<this.capacity){
            now.add(dd);
            now.get(now.size()-1).addeventt(eventName);
            return true;
        }
        else{
            return false;
        }
    }
    public String finishNextEvent()
    {
        if(now.isEmpty()){
            return "NONE";
        }
        else{
            MyDate ddd=now.get(0);int k=0;
            for(int i=1;i<now.size();i++){
                if(MyDate.difference(now.get(i),ddd)<0){
                    ddd=now.get(i);k=i;
                }
                else{
                    if(MyDate.difference(now.get(i),ddd)==0){
                        if(ddd.event.compareTo(now.get(i).event)>0){
                            ddd=now.get(i);k=i;
                        }
                    }
                }
            }
            now.remove(k);
            //System.out.println(ddd.event);
            return ddd.event;
        }
    }
}
