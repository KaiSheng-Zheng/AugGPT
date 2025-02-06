public class MyCalendar {
    private static int amount;
    private MyDate[] myDates;
    private String[] eventName;

    private static int used_amount;

    public MyCalendar(int capacity){
        amount = capacity;

        myDates =  new MyDate[amount];
        eventName = new String[amount];
    }

    public static void setUsed_amount(int used_amount) {
        MyCalendar.used_amount = used_amount;
    }



    public boolean addEvent(MyDate date, String event_Name){
        if(used_amount < amount){
            myDates[used_amount] = date;
            eventName[used_amount] = event_Name;
            used_amount ++;
            return true;
        }else{
           return false;
        }
    }

    private int[][] eventOrder;

    private static int finished_amount;

    public String finishNextEvent(){
        if (finished_amount == 0){
            eventOrder = new int[2][used_amount];

            for (int i = 0; i < used_amount; i++) {
                eventOrder[0][i] = MyDate.sum(myDates[i]);
                eventOrder[1][i] = i;
            }

            for (int i = 0; i < used_amount; i++) {
                for (int j = 0; j < used_amount - i - 1; j++) {
                    if (eventOrder[0][j] < eventOrder[0][j+1]){
                        continue;
                    } else if (eventOrder[0][j] > eventOrder[0][j+1]) {
                        int temp1 = eventOrder[0][j];
                        int temp2 = eventOrder[1][j];
                        eventOrder[0][j] = eventOrder[0][j+1];
                        eventOrder[1][j] = eventOrder[1][j+1];
                        eventOrder[0][j+1] = temp1;
                        eventOrder[1][j+1] = temp2;
                    }else {
                        if (eventName[j].compareTo(eventName[j + 1]) < 0){
                            int temp1 = eventOrder[0][j];
                            int temp2 = eventOrder[1][j];
                            eventOrder[0][j] = eventOrder[0][j+1];
                            eventOrder[1][j] = eventOrder[1][j+1];
                            eventOrder[0][j+1] = temp1;
                            eventOrder[1][j+1] = temp2;
                        }
                    }


                }
            }
        }
        finished_amount ++;
        if (finished_amount < used_amount + 1){
            int temp = eventOrder[1][finished_amount - 1];

            return eventName[temp];
        }else {
            return "NONE";
        }
    }



    public MyDate[] getMyDates() {
        return myDates;
    }

    public void setMyDates(MyDate[] myDates) {
        this.myDates = myDates;
    }

    public String[] getEventName() {
        return eventName;
    }

    public void setEventName(String[] eventName) {
        this.eventName = eventName;
    }
}
