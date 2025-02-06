public class MyCalendar {
    private int capacity;
    int[]daysCount=new int[10000];
    String[][]events=new String[10000][20];

    int count=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String eventName){
        int index=0;
        for (int i=0;i<daysCount.length;i++){
            if(daysCount[i]!=date.days(date)){
                for (int j=0;j<daysCount.length;j++){
                    if (daysCount[j]==0){
                        daysCount[j]=date.days(date);
                        index=j;
                        break;
                    }
                }
            }else index=i;
        }
        if (count<capacity){
            for (int i=0;i<20;i++) {
                if (events[index][i]==null){
                    events[index][i]=eventName;
                    break;
                }
            }
            int length=0;
            for (int i=0;i<20;i++){
                if (events[index][i]!=null)length=i;
            }
            for (int i=0;i<length;i++){
                String s=events[index][i];
                if (events[index][i].compareTo(events[index][i+1])>0){
                    events[index][i]=events[index][i+1];
                    events[index][i+1]=s;
                }
            }
            count++;
            return true;
        }
        return false;
    }
    public String finishNextEvent(){
        String nextEventName="NONE";
        for (int i=0;i<events.length;i++){
            if (events[i][0]!=null){
                for (int j=0;j<events[i].length;j++){
                    if (events[i][j]!=null){
                        nextEventName = events[i][j];
                        events[i][j]=null;
                        capacity++;
                        break;
                    }
                }
            }else nextEventName="NONE";
        }
        return nextEventName;
    }
}