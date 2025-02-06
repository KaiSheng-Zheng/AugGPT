import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class MyCalendar {
    ArrayList<Event> event = new ArrayList<>();
    private int capacity;
    private String[] strings;
    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.thing = 0;
//        this.strings = new String[this.capacity];
//        for (int i = 0;i<capacity;i++){
//            strings[i] = "z";
//            MyDate s = new MyDate(99999,1,1);
//            event.add(s);
//        }
    }

    public ArrayList<Event> getList()  {
        return event;
    }

    public void setThing(int thing) {
        this.thing = thing;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getThing() {
        return this.thing;
    }

    private int thing;

    public boolean addEvent(MyDate date,String eventName) {
        if (this.thing >= this.capacity) {
            return false;
        } else {
            this.thing++;
            event.add(new Event(date,eventName));
            return true;
        }
    }

    public int llllcompare(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            int cmp = Character.compare(s1.charAt(i), s2.charAt(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(s1.length(), s2.length());
    }
    public int dateComparation(MyDate date1,MyDate date2){
        return MyDate.difference(date1,date2);
    }
    public String finishNextEvent() {

        event.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return llllcompare(o1.name,o2.name);
            }
        });
        event.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return dateComparation(o1.myDate,o2.myDate);
            }
        });
        String a = null;
        if (event.isEmpty()){
            a = "NONE";
        }else {
            a = event.get(0).name;
            event.remove(0);
            thing--;
        }
        return a;
    }

}
class Event{
    MyDate myDate;
    String name;
    char kk;
    public Event(MyDate myDate,String name){
        this.name = name;
        this.myDate = myDate;

    }
}
