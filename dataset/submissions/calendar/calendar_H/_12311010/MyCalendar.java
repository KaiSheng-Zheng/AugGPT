import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class MyCalendar {
    int capacity;


    ArrayList<MyDate> dateArrayList = new ArrayList<MyDate>();





    public MyCalendar(int capacity){
    this.capacity = capacity;
    }

    


    public boolean addEvent(MyDate date, String eventName){

        if (dateArrayList.size() >= capacity){
            return false;
        } else {
        dateArrayList.add(date);
        date.EventsOfTheDay.add(eventName);
        return true;
        }
    }









    public String finishNextEvent() {
        Collections.sort(dateArrayList);



        if (dateArrayList.isEmpty()){
            return "NONE";
        }else {
            MyDate minDate = dateArrayList.get(0);
            String minEvent = Collections.min(minDate.EventsOfTheDay);
            String returnString = new String(minEvent);
            minDate.EventsOfTheDay.remove(minEvent);
            if (minDate.EventsOfTheDay.isEmpty()){
                MyDate t = dateArrayList.remove(0);
                if(!dateArrayList.isEmpty()){
                    for (int i = dateArrayList.size()-1;i>=0;i--) {
                        if (dateArrayList.get(i).toString().compareTo(t.toString()) == 0){
                            dateArrayList.remove(i);
                        }
                    }
                }
            }
            return returnString;
        }
    }



}
