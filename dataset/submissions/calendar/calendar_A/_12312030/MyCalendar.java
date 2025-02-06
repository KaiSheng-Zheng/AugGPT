import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    private int num,cnt;
    private ArrayList<MyDate> myDates=new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity=capacity;
        num=0;cnt=0;

    }
    public boolean addEvent(MyDate date, String eventName) {
        if(num==capacity) return false;
        num++;
        MyDate my= new MyDate(date.getYear(),date.getMonth(),date.getDay());
        my.setName(eventName);
        myDates.add(my);
        //System.out.println(date.toString());
        //System.out.println(eventName);
        //System.out.println();
        return true;
    }
    public boolean equals(MyDate a1,MyDate a2) {
        //System.out.println(a1.toString());
        //System.out.println(a2.toString());
        return (a1.getYear()==a2.getYear())&&(a1.getMonth()==a2.getMonth())&&(a1.getDay()==a2.getDay());
    }
    public String getMin(){
        int id=-1;
        //System.out.println(num);
        MyDate res=new MyDate();
        res.setMonth(13);
        for(int i=0;i<=num;i++) {
            if(res.getMonth()==13) {
                res=myDates.get(i);
                id=i;
                continue;
            }

            //System.out.println(res.toString());
            if(equals(myDates.get(i),res)) {
                //System.out.println("wgw");
                if(res.getName().compareTo(myDates.get(i).getName())<0) continue;
                res=myDates.get(i);id=i;
            }
            if(MyDate.is_big(myDates.get(i),res)) continue;
            id=i;
            res=myDates.get(i);
        }
        myDates.remove(id);
        return res.getName();
    }
    public String finishNextEvent(){
        if(num==0) return "NONE";
        num--;
        return getMin();
    }
    public void work() {
        for(int i=0;i<myDates.size();i++) {
            System.out.println(myDates.get(i).toString());
            System.out.println(myDates.get(i).getName());
            System.out.println();
        }
    }
}
