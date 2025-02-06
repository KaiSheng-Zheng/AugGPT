import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyDate> ed;
    private ArrayList<String> en;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        ed=new ArrayList<>();
        en=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        int place=-1;//the place to add//how much event in the day
        if(ed.size()==this.capacity)
            return false;

        for (int i = 0; i < en.size(); i++) {
            int d=MyDate.difference(ed.get(i),date);
            if(d>0){place=i;break;}
            if(d==0){
                int minus=en.get(i).compareTo(eventName);
                if(minus>0){
                    place=i;break;
                }
            }
        }
        if(place==-1){
            ed.add(date);
            en.add(eventName);
            return true;
        }
        ed.add(place,date);
        en.add(place,eventName);
        return true;
    }
    public String finishNextEvent(){
        if(!ed.isEmpty()){
            String temp=en.get(0);
            ed.remove(0);
            en.remove(0);
            return temp;
        }
        return "NONE";
    }
    public void check(){
        System.out.println(ed);
        System.out.println(en);
    }
}
