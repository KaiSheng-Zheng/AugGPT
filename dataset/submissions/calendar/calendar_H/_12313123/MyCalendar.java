public class MyCalendar {
    private int capacity;
    private int current=0;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        MyDate.clear();

    }
    public boolean addEvent(MyDate date, String eventName){
        if(current+1>capacity){
            return false;
        }
        date.addEvent(eventName);
        current++;
        return true;
    }
    public String finishNextEvent(){
        for(MyDate date:MyDate.getAlldate()){
            if(date.getEventToday().size()==0) {continue;}
            String doing=date.getEventToday().get(0);
            current--;
            date.deleteDone(0);
            return doing;


        }
        return "NONE";
    }






}
