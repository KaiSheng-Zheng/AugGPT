import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int number=0;
    ArrayList<MyDate>a=new ArrayList<MyDate>();
    ArrayList<String>b=new ArrayList<String>();
    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date,String eventName){
        if (capacity<=number){
            return false;
        }else{
            number+=1;
            int counter=0;
            if (!a.isEmpty()) {
                for (int i = 0; i < a.size(); i++) {
                    if(MyDate.difference(a.get(i),date)<0){
                        counter+=1;
                    }else if(MyDate.difference(a.get(i),date)==0){
                        if(eventName.compareTo(b.get(i))>=0){
                            counter+=1;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }a.add(counter,date);
                b.add(counter,eventName);
            }else{
                a.add(date);
                b.add(eventName);
            }
            return true;
        }
    }
    public String finishNextEvent(){
        if(a.isEmpty()){
            return "NONE";
        }else {
                String c=b.get(0);
                a.remove(0);
                b.remove(0);
                number-=1;
                return c;
        }
    }
}
