
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.time.LocalDate;

public class MyCalendar {
    private int capacity;
    private ArrayList<String> events=new ArrayList<>();


    private ArrayList<MyDate> myDateArrayList=new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String eventName ){
        if(events.size()<capacity){
            events.add(eventName);
            myDateArrayList.add(date);
            return true;
        }else {
            return false;
        }
    }
    public String ranking(){

            for (int h = 0; h < events.size(); h++) {
                for (int i = 0; i < events.size() - 1; i++) {
                    LocalDate d1 = LocalDate.of(myDateArrayList.get(i).getYear(),
                            myDateArrayList.get(i).getMonth(),
                            myDateArrayList.get(i).getDay());
                    LocalDate d2 = LocalDate.of(myDateArrayList.get(i + 1).getYear(),
                            myDateArrayList.get(i + 1).getMonth(),
                            myDateArrayList.get(i + 1).getDay());
                    if (d1.isAfter(d2)) {
                        Collections.swap(myDateArrayList, i, i + 1);
                        Collections.swap(events, i, i + 1);
                    }
                }
            }


            for (int h = 0; h < events.size(); h++) {
                for (int i = 0; i < events.size() - 1; i++) {
                    if (myDateArrayList.get(i) == myDateArrayList.get(i + 1)) {
                        int result = events.get(i).compareTo(events.get(i + 1));
                        if (result > 0) {
                            Collections.swap(events, i, i + 1);
                        }
                    }
                }
            }

        if(events.size()>=1){
            return events.get(0);
        }else {
            return "NONE";
        }
    }
    public String finishNextEvent(){
        if(events.size()>=1) {
            String finishNextEvent = ranking();
            update(events, myDateArrayList);
            return finishNextEvent;
        }else{
            return "NONE";
        }

    }
    public void update(ArrayList events, ArrayList myDateArrayList){
        events.remove(0);
        myDateArrayList.remove(0);
    }


}
