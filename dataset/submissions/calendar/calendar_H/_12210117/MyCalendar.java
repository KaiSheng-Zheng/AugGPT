import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<String> event;
    private ArrayList<String> eventfordel;
    private ArrayList<MyEvent> event2;
    private ArrayList<MyDate> eventday;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.event = new ArrayList<String>();
        this.eventday = new ArrayList<>();
        this.eventfordel = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName){
        if(event.size() < capacity){
            event.add(eventName);
            eventday.add(date);
            return true;
        }else{
            return false;
        }
    }

    public String finishNextEvent(){
        ArrayList menu = new ArrayList();
        if(this.event.isEmpty()){
            return "NONE";
        }else{
            MyDate miniday = eventday.get(0);
            for(int i = 0;i < event.size();i += 1){
                int cha = MyDate.difference(miniday,eventday.get(i));
                if(cha > 0){
                    miniday = eventday.get(i);
                }
            }
            for(int j = 0;j < event.size();j += 1){
                if(eventday.get(j) == miniday){
                    eventfordel.add(event.get(j));
                    menu.add(j);
                }
            }
            String stringfordel = eventfordel.get(0);
            int deldate = 0;
            int[] menulist = new int[menu.size()];
            for(int l = 0;l < menu.size();l += 1){
                menulist[l] = (int)menu.get(l);
            }
            for(int k = 0;k < eventfordel.size();k += 1){
                int shuida = stringfordel.compareTo(eventfordel.get(k));
                if(shuida > 0){
                    stringfordel = eventfordel.get(k - 1);
                    deldate = menulist[k - 1];
                }
            }
            event.remove(stringfordel);
            eventday.remove(deldate);
            return stringfordel;
        }
    }
}