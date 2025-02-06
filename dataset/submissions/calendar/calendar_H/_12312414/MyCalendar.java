import java.util.ArrayList;
import java.util.Comparator;

public class MyCalendar {
    private int capacity;
    private int numofdates = 0;
    private int numofevents = 0;
    private ArrayList<ArrayList<String>> eventList = new ArrayList<>();
    private ArrayList<MyDate> myDates = new ArrayList<>();

    public boolean addEvent(MyDate date, String eventName) {
        if (numofevents >= capacity) {
            return false;
        }
        if (numofevents == 0) {
            myDates.add(date);
            eventList.add(new ArrayList<String>());
            eventList.get(numofdates).add(eventName);
            numofevents++;
            numofdates++;
            return true;
        } else {
            if (myDates.contains(date)) {
                eventList.get(myDates.indexOf(date)).add(eventName);
                numofevents++;
                eventList.get(myDates.indexOf(date)).sort(Comparator.naturalOrder());
            } else {
                myDates.add(date);
                eventList.add(new ArrayList<String>());
                eventList.get(numofdates).add(eventName);
                numofdates++;
                numofevents++;
                for (int i = 0; i < myDates.size() - 1; i++) {
                    for (int j = 0; j < myDates.size() - 1 - i; j++) {
                        if (MyDate.difference(myDates.get(j), myDates.get(j + 1)) > 0) {
                            MyDate temp1 = myDates.get(j);
                            MyDate temp2 = myDates.get(j + 1);
                            myDates.set(j, temp2);
                            myDates.set(j + 1, temp1);
                            ArrayList<String> temp3 = eventList.get(j);
                            ArrayList<String> temp4 = eventList.get(j + 1);
                            eventList.set(j, temp4);
                            eventList.set(j + 1, temp3);
                        }
                    }
                }
                for (int i = 0; i < eventList.size(); i++) {
                    eventList.get(i).sort(Comparator.naturalOrder());
                }
            }
            return true;
        }
    }

    public String finishNextEvent() {
        if (eventList.size() == 0) {
            return "NONE";
        } else {
            String temp = eventList.get(0).get(0);
            eventList.get(0).remove(0);
            if (eventList.get(0).size() == 0){
                eventList.remove(0);
                numofdates--;
                myDates.remove(0);
            }
            numofevents--;
            return temp;
        }
    }

    public MyCalendar() {
    }

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<ArrayList<String>> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<ArrayList<String>> eventList) {
        this.eventList = eventList;
    }

    public ArrayList<MyDate> getMyDates() {
        return myDates;
    }

    public void setMyDates(ArrayList<MyDate> myDates) {
        this.myDates = myDates;
    }
}