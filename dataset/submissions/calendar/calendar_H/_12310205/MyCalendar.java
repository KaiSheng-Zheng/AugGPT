import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private int inner=0;
    private ArrayList<String> event = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName) {
        if (inner == capacity) return false;
        else {
            list.add(String.valueOf(date.totals));
            event.add(eventName);
            inner++;
            return true;
        }
    }
    public String finishNextEvent() {
        if (inner == 0){
            return "NONE";
        }
        else {
            int a=0,b=0;
            String c = "}";
            for (String s : list) {
                if (a == 0) a = Integer.parseInt(s);
                if (a > Integer.parseInt(s)) {
                    a = Integer.parseInt(s);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (Integer.parseInt(list.get(i)) == a) {
                    if (c.compareTo(event.get(i))>0){
                        c = event.get(i);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (event.get(i).equals(c)){
                    b = i;
                    break;
                }
            }
            list.remove(b);
            event.remove(b);
            inner--;
            return c;
        }
    }
}