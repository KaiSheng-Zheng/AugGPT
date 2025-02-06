public class MyCalendar {
    int capacity;
    int num=0;
    MyDate[]myDates;
    String[]myCalendars;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        myDates=new MyDate[capacity];
        myCalendars=new String[capacity];
    }
    public boolean addEvent(MyDate date, String eventName){
        if (num==capacity){
            return false;
        }else {
            myDates[num]=date;
            myCalendars[num]=eventName;
            num++;
            return true;
        }
    }
    public String finishNextEvent(){
        if (num>=2){
            for (int i=num;i>=1;i--){
                for (int j=1;j<=i-1;j++){
                    if (MyDate.difference(myDates[j-1],myDates[j])<0||(MyDate.difference(myDates[j-1],myDates[j])==0&&myCalendars[j-1].compareTo(myCalendars[j])<0)){
                        MyDate temp=myDates[j-1];
                        myDates[j-1]=myDates[j];
                        myDates[j]=temp;
                        String Temp=myCalendars[j-1];
                        myCalendars[j-1]=myCalendars[j];
                        myCalendars[j]=Temp;
                    }
                }
            }
        }
        if (num>=1){
            String name=myCalendars[num-1];
            num--;
            return name;
        }else return "NONE";
    }
}
