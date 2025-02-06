
public class MyCalendar {
    private int capacity;
    private int counter=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        Events=new MyDate[capacity];
    }


    private  MyDate[] Events;
    public boolean addEvent(MyDate date, String eventName){

        if (counter+1<=capacity){
            counter++;
            Events[counter-1]=new MyDate(date);
            Events[counter-1].setEventName(eventName);
            return true;
        }
        return false;
    }



    public String finishNextEvent(){
        for (int i=0;i< counter;i++){
            for (int j=0;j+1<counter;j++){
                if (Events[j].getDayNum()>Events[j+1].getDayNum()){
                    MyDate d=Events[j];
                    Events[j]=Events[j+1];
                    Events[j+1]=d;
                }
                if (Events[j].getDayNum()==Events[j+1].getDayNum()){
                    if (Events[j].getEventName().compareTo(Events[j+1].getEventName())>0){
                        MyDate d=Events[j];
                        Events[j]=Events[j+1];
                        Events[j+1]=d;
                    }
                }
            }
        }
        if (counter<=capacity&&counter>0){
            String event=Events[0].getEventName();
            for (int i=0;i+1<capacity;i++){
                if (Events[i+1]!=null){
                    Events[i]=new MyDate(Events[i+1]);
                }
            }
            counter--;
            return event;
        }

        return "NONE";
    }
}
