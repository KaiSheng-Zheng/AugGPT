import java.util.ArrayList;
import java.util.Date;

class MyCalendar {
    private int capacity;
    private ArrayList<String> events = new ArrayList<String>();
    private ArrayList<MyDate> dates = new ArrayList<MyDate>();
    private int numOfEvents=0;
    private MyDate theEarlierOne=new MyDate(0,0,0);
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<String> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }
    //yixia wei fangfa


    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        if(numOfEvents<=capacity-1){
            numOfEvents++;
            dates.add(date);
            events.add(eventName);
            return true;
        }
        else {
            return false;
        }
    }

    public String finishNextEvent(){
        if(events.isEmpty()){
            if(numOfEvents>0){
                numOfEvents--;
            }
            return "NONE";
        }
        else if (events.size()==1){
            String theReturn = "";
            theReturn = events.get(0);
            events.clear();
            dates.clear();
            numOfEvents--;
            return theReturn;
        }
        else {
            ArrayList<MyDate> earliest = new ArrayList<MyDate>(1);
            String theReturn = "NONE";
            if (dates.size() == 1) {
                return events.get(0);
            }
            theEarlierOne=dates.get(0);
            for (int n = 0; n <= dates.size() - 1; n++) {
                theEarlierOne = MyDate.theEarlier(dates.get(n), theEarlierOne);
            }
            ArrayList<String> theSameTimeEvents = new ArrayList<String>();
            for(int n=0; n<= dates.size()-1;n++){
                if(MyDate.isEqualTo(theEarlierOne,dates.get(n))){
                    theSameTimeEvents.add(events.get(n));
                }
            }
            theReturn=theSameTimeEvents.get(0);
            for(int n=0; n<=theSameTimeEvents.size()-1;n++){
                int i = theReturn.compareTo(theSameTimeEvents.get(n));
                if(i<0){
                }
                else {
                    theReturn=theSameTimeEvents.get(n);
                }
            }
            for(int n=0;n<=events.size()-1;n++){
                if(theReturn.equals(events.get(n))){
                    events.remove(n);
                    dates.remove(n);
                    break;
                }
            }
            numOfEvents--;
            return theReturn;
        }
    }
}
