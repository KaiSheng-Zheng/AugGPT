public class MyCalendar {
    private static int eventNumber=0;
    private int capacity;
    private String[] finishedEvent=new String[10000];
    private int[] EventDay=new int[10000];
    private static int i=0;
    public int getEventNumber(){
        return this.eventNumber;
    }

    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(eventNumber<capacity){
            eventNumber++;
            date.setEvent(eventName);
            date.i++;
            if(i==0){
                finishedEvent[i]=eventName;
                EventDay[i]=date.DayNumber(date);
            }else{
                finishedEvent[i]=eventName;
                EventDay[i]=date.DayNumber(date);
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k <i ; k++) {
                        if(EventDay[k]>EventDay[k+1]){
                            swap(EventDay,finishedEvent,k,k+1);
                        } else if (EventDay[k]==EventDay[k+1]) {
                            int result=finishedEvent[k].compareTo(finishedEvent[k+1]);
                            if(result>0){
                                swap(EventDay,finishedEvent,k,k+1);
                            }
                        }
                    }
                }
            }

            i++;
            return true;
        }else{
            finishedEvent[i]="NONE";
            EventDay[i]=date.DayNumber(date);
            return false;
        }
    }
    private int n=-1;
    public String finishNextEvent(){
       n++;
       if(n<i){
           return finishedEvent[n];
       }else{
           return "NONE";
       }
    }
    public void swap(int[] EventNumber,String[] finishedEvent,int j,int k){
        String temp1=finishedEvent[j];
        String temp2=finishedEvent[k];
        finishedEvent[j]=temp2;
        finishedEvent[k]=temp1;
        int temp3=EventNumber[j];
        int temp4=EventNumber[k];
        EventNumber[k]=temp3;
        EventNumber[j]=temp4;
    }
}

