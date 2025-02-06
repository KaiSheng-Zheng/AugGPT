public class MyCalendar {
    int capacity = 15;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        for (int k = 0 ; k <datesum.length;k++){
            datesum[k]=987654321;
        }

    }
    int jishu = 0;
    int []datesum= new int[capacity];

    String []Strsum = new String[capacity];
    public boolean addEvent(MyDate date, String eventName){
        datesum[jishu]= date.DateNum();
        Strsum[jishu]= eventName;
        jishu++;
        return (jishu<=capacity);
    }
    public String finishNextEvent(){
        int datemin=datesum[0];
        int minnum=0;
        for (int j = 1;j<capacity;j++){
            if(datesum[j]<datemin){
                minnum=j;
                datemin=datesum[j];
            }
            if(datesum[j]==datemin){
                int chong =Strsum[minnum].compareTo(Strsum[j]);
                if(chong>0){
                    minnum=j;
                    datemin=datesum[j];
                }
            }
        }
        jishu--;
        if(datesum[minnum]==987654321){
            return "NONE";
        }else {
            datesum[minnum]=987654321;
            return Strsum[minnum];
        }

    }


}
