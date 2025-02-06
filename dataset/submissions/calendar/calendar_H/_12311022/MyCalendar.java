
public class MyCalendar {
    String[] eventName;
    MyDate[] eventDate;
    public int addEventTime;
    public int finishEventTime;
    public int capacity;
    public MyCalendar(int capacity){
        this.eventName=new String[10*capacity];
        this.eventDate=new MyDate[10*capacity];
        this.capacity=capacity;

    }
    public boolean addEvent(MyDate Date,String Name){
        boolean output=addEventTime-finishEventTime<capacity;
        if(addEventTime-finishEventTime<capacity){
        this.eventDate[addEventTime]=Date;
        this.eventName[addEventTime]=Name;
        addEventTime++;
        for(int i=addEventTime-1;i>finishEventTime;i--){
         if(eventDate[i].length<eventDate[i-1].length){
             MyDate switchDate;
             String switchName;
             switchDate=eventDate[i-1];
             switchName=eventName[i-1];
             eventDate[i-1]=eventDate[i];
             eventName[i-1]=eventName[i];
             eventDate[i]=switchDate;
             eventName[i]=switchName;
         }
         if(eventDate[i].length==eventDate[i-1].length) {
             if (eventName[i].compareTo(eventName[i - 1]) < 0) {
                 MyDate switchDate;
                 String switchName;
                 switchDate = eventDate[i - 1];
                 switchName = eventName[i - 1];
                 eventDate[i - 1] = eventDate[i];
                 eventName[i - 1] = eventName[i];
                 eventDate[i] = switchDate;
                 eventName[i] = switchName;
             }
         }
        }}
        return output;//
    }
    public String finishNextEvent(){
        String output="";
        if(addEventTime-finishEventTime>0 ){
            output=eventName[finishEventTime++];
        }
        else{
            output="NONE";
        }
        return output;
    }

}
