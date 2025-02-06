public class MyCalendar {
    private int capacity;
    private int cntAdd=0;
    private int cnt=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        String[][] events=new String[capacity][4];
        for (int i = 0; i < capacity; i++) {
            events[i][0]="20000";
            events[i][1]="13";
            events[i][2]="32";
            events[i][3]="NONE";
        }
        this.events=events;
    }
    private String[][] events=new String[capacity][4];

    public boolean addEvent(MyDate date,String eventName){
        boolean result;
        if (cntAdd > capacity-1) {
            result=false;
        }else {
            events[cntAdd][0] = String.valueOf(date.getYear());
            events[cntAdd][1] = String.valueOf(date.getMonth());
            events[cntAdd][2] = String.valueOf(date.getDay());
            events[cntAdd][3] = eventName;
            cntAdd++;
            result=true;
        }
        return result;
    }
    public String finishNextEvent(){
        String event;
        if(cnt>capacity-1){
            event="NONE";
        }else {
            String[] temparr;
            for (int i = 0; i < capacity - 1; i++) {
                for (int j = 0; j < capacity-1 - i; j++) {
                    if (Integer.parseInt(events[j][0]) > Integer.parseInt(events[j+1][0])) {
                        temparr = events[j];
                        events[j] = events[j + 1];
                        events[j + 1] = temparr;
                    }else if(Integer.parseInt(events[j][0]) == Integer.parseInt(events[j+1][0])){
                        if(Integer.parseInt(events[j][1])>Integer.parseInt(events[j+1][1])){
                            temparr = events[j];
                            events[j] = events[j + 1];
                            events[j + 1] = temparr;
                        }else if(Integer.parseInt(events[j][1])==Integer.parseInt(events[j+1][1])){
                            if(Integer.parseInt(events[j][2])>=Integer.parseInt(events[j+1][2])){
                                temparr = events[j];
                                events[j] = events[j + 1];
                                events[j + 1] = temparr;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < capacity - 1; i++) {
                for (int j = 0; j < capacity-1 - i; j++) {
                    int comparedResult = events[j][3].compareTo(events[j + 1][3]);
                    if (Integer.parseInt(events[j][0]) == Integer.parseInt(events[j+1][0])&&Integer.parseInt(events[j][1])==Integer.parseInt(events[j+1][1])&&Integer.parseInt(events[j][2])==Integer.parseInt(events[j+1][2])) {
                        if(comparedResult>0) {
                            temparr = events[j];
                            events[j] = events[j + 1];
                            events[j + 1] = temparr;
                        }
                    }
                }
            }
            event = events[cnt][3];
            cnt++;
        }
        return event;
    }
}