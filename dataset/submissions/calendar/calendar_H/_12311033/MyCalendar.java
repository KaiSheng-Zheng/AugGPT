import java.util.ArrayList;
public class MyCalendar {
    private int st;
    private int end;
    private int size = 0;
    private ArrayList<MyDate> array1;
    private ArrayList<String> array2;
    public MyCalendar(int capacity){
        this.size = capacity;
        array1 = new ArrayList<>();
        array2 = new ArrayList<>();
        st = 0;
        end = -1;
    }
    private static boolean isBigger(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        for(int i = 0; i < l1 && i < l2; i++){
            if(s1.charAt(i) != s2.charAt(i))
                return s1.charAt(i) > s2.charAt(i);
        }
        return l1 > l2;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(this.end - this.st + 1 >= this.size){
            return false;
        }
        boolean flag = true;
        for (int i = this.st; i <= this.end; i++) {
            if (array1.get(i).LaterThan(date) || (MyDate.difference(array1.get(i), date) == 0 && isBigger(array2.get(i), eventName))) {
                array1.add(i, date);
                array2.add(i, eventName);
                flag = false;
                break;
            }
        }
        if(flag){
            array1.add(date);
            array2.add(eventName);
        }
        this.end++;
        return true;
    }
    public String finishNextEvent(){
        if(this.st <= this.end) {
            int tmp = this.st;
            this.st++;
            return array2.get(tmp);
        }
        else
            return "NONE";
    }
}
