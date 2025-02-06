import java.util.ArrayList;
import java.util.Arrays;
public class MyCalendar {
    private int a;
    private ArrayList<MyEvent> events;


    public MyCalendar(int capacity){
        this.a = capacity;
        this.events = new ArrayList<>();

    }
    public boolean addEvent(MyDate date, String eventName){
        if (this.events.size()<a){
             MyEvent b = new MyEvent(date,eventName);
             events.add(b);
//            System.out.println(events);
//            System.out.println(events.size());
            return true;
        }else{
            return false;
        }

    }

    public String finishNextEvent(){

        if (this.events.isEmpty()){
            return "NONE";
        }else{
            int [] diff = new int[events.size()];
            int [] diffIndex = new int[events.size()];
            MyDate date0 = events.get(0).getDate();
            for (int i = 0; i < events.size(); i++) {


                diff[i] = MyDate.difference(date0, events.get(i).getDate());
                diffIndex[i] = MyDate.difference(date0, events.get(i).getDate());


                }
                Arrays.sort(diffIndex);
                int max = diffIndex[diffIndex.length-1];
                ArrayList<MyEvent> linshi = new ArrayList<MyEvent>();
                for (int j = 0; j < events.size(); j++) {
                    if(diff[j]== max){
                        linshi.add(events.get(j));
                    }
                }

                MyEvent temp = linshi.get(0);
            for (int i = 1; i < linshi.size(); i++) {
                if (temp.getEventName().compareTo(linshi.get(i).getEventName()) > 0){
                    temp = linshi.get(i);
                }
            }
            events.remove((Object)temp);

            return temp.getEventName();
            }
//            events.remove();
//            s1.compareTo(s2) xiao yu 0de xiao

        }

    }