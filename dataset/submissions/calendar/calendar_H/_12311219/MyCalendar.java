import java.util.ArrayList;

public class MyCalendar {
    private int capcity;
    ArrayList<MyDate> myDates;
    ArrayList<String> myEvents;
    public MyCalendar(int capcity) {
          this.capcity=capcity;
          this.myDates=new ArrayList<>();
          this.myEvents=new ArrayList<>();
    }

    public MyCalendar() {
    }

    public MyCalendar(int capcity, ArrayList<MyDate> myDates, ArrayList<String> myEvents) {
        this.capcity = capcity;
        this.myDates = myDates;
        this.myEvents = myEvents;
    }


    public boolean addEvent(MyDate date, String eventName) {
        int tem = 0;
        if (myEvents.isEmpty()) {
            myDates.add(date);
            myEvents.add(eventName);
            return true;
        } else if (myEvents.size() < capcity) {
            int date1calculateor = date.calculateTotalDays();
            for (int i = 0; i < myDates.size(); i++) {
                MyDate date2 = myDates.get(i);
                int date2calculator = date2.calculateTotalDays();
                if (date1calculateor - date2calculator > 0 ||
                        (date1calculateor == date2calculator && eventName.compareTo(myEvents.get(i)) > 0)) {
                    tem++;
                }
            }
            if (tem < myEvents.size()) {
                myEvents.add(tem, eventName);
                myDates.add(tem,date);
                return true;
            } else {
                myEvents.add(eventName);
                myDates.add(date);
                return true;
            }


        } else {
            return false;
        }


    }
   public String finishNextEvent(){
       if(myEvents.size()>0) {String firstevent=myEvents.get(0);
        myEvents.remove(0);
        myDates.remove(0);
        return firstevent;}
       else{return "NONE";}

    }




}