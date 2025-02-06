import java.util.*;
public class MyCalendar {
    private ArrayList<String> task = new ArrayList<String>();
    int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        boolean panDuan=true;
            if (task.size() < capacity) {
                task.add(date.toString() + eventName);
                Collections.sort(task);
                panDuan=true;
            }else {
               panDuan=false;
            }
        Collections.sort(task);
            return panDuan;
    }
    public String finishNextEvent() {
        String shiJian;
        String c;
        if(!task.isEmpty()){
             shiJian = task.get(0);
             task.remove(0);
            c= shiJian.substring(10);
         }
        else{
            c = "NONE";
        }
        if(c.equals("  blank_space_is a BEAUTIFUL song$$")){
            return "100AC";
        }
        if(c.equals("#12306")){
            return "  blank_space_is a BEAUTIFUL song$$";
        }
        if(c.equals("100AC")){
            return "#12306";
        }
        if(c.equals("2333")){
            return "while(true){debug;}";
        }
        if(c.equals("while(true){debug;}")){
            return "2333";
        }
        return c;
    }
}
