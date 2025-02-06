import java.util.ArrayList;
import java.util.Objects;

public class MyCalendar {
    private int capacity;
    private int count=0;
    private ArrayList<Integer> a =new ArrayList<Integer>();
    private ArrayList<String> b =new ArrayList<String>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        count++;
        MyDate oDate=new MyDate(1949,1,1);
        if(count>capacity){
            return false;
        }
        else{
            a.add(MyDate.difference(oDate, date));
            b.add(eventName);
            return true;
        }
    }
    public String finishNextEvent(){
        int r=0;
        if(a.size()>0){
            int j=a.get(0);
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i)>j){
                    j=a.get(i);
                    r=i;
                }
                else if(Objects.equals(a.get(i), j)){
                    if(b.get(i).compareTo(b.get(r))<0){
                        j=a.get(i);
                        r=i;
                    }
                }
            }
            if(a.size()>0){
                a.remove(r);
                String a =b.get(r);
                b.remove(r);
                return a;
            }else{
                return "NONE";
            }
        }
        else{
            return "NONE";
        }
    }
}
