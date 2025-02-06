import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    private int now=0;
    ArrayList<MyDate> Date=new ArrayList<>();
    ArrayList<String> Name=new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String name){
        if(now==capacity) return false;
        Date.add(new MyDate(date.year,date.month,date.day));
        Name.add(name);
        now++;
        return true;
    }
    public String finishNextEvent(){
        if(now==0) return "NONE";
        else{
            int minn=0;
            for(int i=1;i<now;i++){
                if(MyDate.cmp(Date.get(i),Date.get(minn))){
                    minn=i;
                }
                else if(!MyDate.cmp(Date.get(minn),Date.get(i))){
                    if(Name.get(i).compareTo(Name.get(minn))<0){
                        minn=i;
                    }
                }
            }
            String res=Name.get(minn);
            Name.remove(minn);Date.remove(minn);now--;
            return res;
        }
    }
}
