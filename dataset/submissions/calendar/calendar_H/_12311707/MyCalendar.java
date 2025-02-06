import java.util.*;

class Fuck{
    private MyDate key;
    private String value;
    private int id;
    private static int idx=0;
    public Fuck(MyDate key,String value){
        this.key=key;
        this.value=value;
        this.id=++idx;
    }
    public MyDate getKey(){return key;}
    public String getValue(){return value;}
    public int getId(){return id;}
}

public class MyCalendar {
    private static int capacity;

    private TreeSet<Fuck>set=new TreeSet<>(new Comparator<>() {
        @Override
        public int compare(Fuck o1, Fuck o2) {
            if(MyDate.difference(o1.getKey(),o2.getKey())!=0)return MyDate.difference(o1.getKey(),o2.getKey());
            if(o1.getValue().compareTo(o2.getValue())!=0)return o1.getValue().compareTo(o2.getValue());
            return o1.getId()-o2.getId();
        }
    });
    public MyCalendar(int capacity){
        MyCalendar.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
//        System.out.println(set.size());
        if(set.size()>=capacity)return false;
        var temp=set.add(new Fuck(date,eventName));
        return true;
    }
    public String finishNextEvent(){
        if(set.isEmpty())return "NONE";
        String res=set.first().getValue();
        set.remove(set.first());
        return res;
    }
}
