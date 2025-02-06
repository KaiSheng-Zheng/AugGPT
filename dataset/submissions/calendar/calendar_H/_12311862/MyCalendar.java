import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyCalendar {
    Scanner in = new Scanner(System.in);
    int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    int number = 0;
    public ArrayList<MyDate> madate1 = new ArrayList<>();
    public ArrayList<String> medate2 = new ArrayList<>();

    public boolean addEvent(MyDate date, String eventName) {
        number++;
        if (number <= capacity) {
            madate1.add(date);
            medate2.add(eventName);
            return true;
        }
        return false;
    }
    int la=-1;
    public String finishNextEvent(){

        medate2.add("NONE");
        la++;

        for (int j = 0;j<madate1.size();j++) {
            for (int i = 0; i < madate1.size()-1; i++) {
                if (madate1.get(i).getYear() > madate1.get(i + 1).getYear()) {
                    Collections.swap(madate1, i, i + 1);
                    Collections.swap(medate2,i,i+1);
                }else if (madate1.get(i).getYear()==madate1.get(i+1).getYear()){
                    if (madate1.get(i).getMonth()>madate1.get(i+1).getMonth()){
                        Collections.swap(madate1,i,i+1);
                        Collections.swap(medate2,i,i+1);
                    }else if (madate1.get(i).getMonth()==madate1.get(i+1).getMonth()){
                        if (madate1.get(i).getDay()>madate1.get(i+1).getDay()){
                            Collections.swap(madate1,i,i+1);
                            Collections.swap(medate2,i,i+1);
                        } else if (madate1.get(i).getDay() == madate1.get(i + 1).getDay()) {
                            char last1 = medate2.get(i).charAt(0);
                            char last2 = medate2.get(i+1).charAt(0);
                            String last3 = String.valueOf(last1);
                            String last4 = String.valueOf(last2);
                            int last = last3.compareTo(last4);
                            if (last>0){
                                Collections.swap(medate2,i,i+1);
                            }
                        }
                    }
                }
            }
        }
        String s = medate2.get(la);
        return s;
    }
}
