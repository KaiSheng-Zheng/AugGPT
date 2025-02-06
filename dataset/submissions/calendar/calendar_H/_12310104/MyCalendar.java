public class MyCalendar {
    private int maxcapacity;
    private int capacity = 0;
    private MyDate[] Calender_Dates;
    private String[] Calender_Events;



    public MyCalendar(int capacity){
        this.maxcapacity = capacity;
        Calender_Dates= new MyDate[maxcapacity];
        Calender_Events = new String[maxcapacity];

    }




    public boolean addEvent(MyDate date,String eventName){
        if(capacity<maxcapacity){
            capacity++;
            int i = 0;
            for(;i<maxcapacity;i++){
                if(Calender_Dates[i] == null){
                    Calender_Dates[i] = date;
                    Calender_Events[i] = eventName;
                    return true;
                }
                if(MyDate.difference(date, Calender_Dates[i])<0){
                    for (int j = Calender_Dates.length-2; j >=i; j--) {
                            Calender_Dates[j+1] = Calender_Dates[j];
                            Calender_Events[j+1] = Calender_Events[j];
                        }
                    Calender_Events[i] = eventName;
                    Calender_Dates[i] = date;
                    return true;
                }
                if(MyDate.difference(date, Calender_Dates[i])==0){
                    if(eventName.compareTo(Calender_Events[i])<0){
                        for (int j = Calender_Dates.length-2; j >=i; j--) {
                            Calender_Dates[j+1] = Calender_Dates[j];
                            Calender_Events[j+1] = Calender_Events[j];
                        }
                        Calender_Dates[i] = date;
                        Calender_Events[i] = eventName;
                        return true;
                    }
                }

            }

        }
        return false;
    }

    public String finishNextEvent(){
        String tmp = Calender_Events[0];
        if (tmp == null) {
            return "NONE";
        }
        capacity--;
        for (int i = 0; i < Calender_Dates.length-1; i++) {
            Calender_Dates[i] = Calender_Dates[i+1];
            Calender_Events[i] = Calender_Events[i+1];
        }

        Calender_Dates[Calender_Dates.length-1] = null;
        Calender_Events[Calender_Dates.length-1] = null;
        return tmp;
    }


}
