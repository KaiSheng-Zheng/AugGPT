import java.util.ArrayList;
import java.util.Comparator;

public class MyCalendar {
    private int date,i;
    private  int year;
    private int month;
    private int day;
    public  void MyDate(int year, int month, int day) {
        this.year = year;
        this.month=month;
        this.day=day;
    }
    ArrayList<String> a=new ArrayList<String>();
    public MyCalendar(int capacity) {
        this.i=capacity;
    }
        public boolean addEvent(MyDate date, String eventName){
        String str=date.toString()+eventName;
                a.add(str);
                if(a.size()>i) {
                    for(int j=a.size()-1;j>=i;j--){
                        a.remove(j);
                    }
                    a.sort(Comparator.naturalOrder());
                    return false;
                }else{
                    a.sort(Comparator.naturalOrder());
                    return true;
                }
        }
    public String finishNextEvent(){
        if(a.size()==0) {
            return "NONE";
        }else{
            String str=a.get(0).substring(10);
            a.remove(0);
            return str;
        }
    }
}