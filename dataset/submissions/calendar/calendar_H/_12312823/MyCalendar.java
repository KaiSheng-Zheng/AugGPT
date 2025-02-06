import java.util.ArrayList;
public class MyCalendar {

    private int capacity;

    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size()<capacity){
            events.add(new MyEvent(date,eventName));
            return true;
        }
        else {
            return  false;
        }
    }










    public String finishNextEvent(){

        if (events.isEmpty()){
            return "NONE";
        }
        else {
            MyDate MIN=events.get(0).getDate();
            ArrayList<MyEvent> a =new ArrayList<MyEvent>();
            for (int i=0;i<events.size();i++){
                if (MyDate.difference(MIN , events.get(i).getDate())>=0){
                    MIN=events.get(i).getDate();

                }


            }
            for (int i=0;i<events.size();i++){
                if (events.get(i).getDate().equals(MIN)){
                    a.add(events.get(i));
                }
            }
            String M=a.get(0).getEventName();

            for (int i=0;i<a.size();i++){
                if (a.get(i).getEventName().compareTo(M)<=0){
                    M=a.get(i).getEventName();
                }
            }

            int k=0;
            for (int i = 0; i <events.size(); i++) {
                if (events.get(i).equals(new MyEvent(MIN, M))){
                    k=i;
                }
        }


            events.remove(k);
            return M;
        }


    }
}