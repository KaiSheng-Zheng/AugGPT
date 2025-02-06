import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    private int eventNumber = 0;
    private ArrayList<String> dateList = new ArrayList<String>();
    private ArrayList<String> eventList = new ArrayList<String>();
    private static int firstTime = 1;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        boolean addEvent = true;
        if (eventNumber < capacity) {
            dateList.add(date.toString());
            eventList.add(eventName);
            eventNumber++;
        } else {
            addEvent = false;
        }
        return addEvent;
    }

    public String finishNextEvent() {
        for (int i = 0; i < dateList.size(); i++) {
            for (int j = 0; j < dateList.size() - 1; j++) {
                if (JudgeTurn(dateList.get(j), dateList.get(j + 1)) == 2) {
                    String str1 =dateList.get(j);
                    dateList.set(j , dateList.get(j+1));
                    dateList.set(j+1 , str1);
                    String str2 = eventList.get(j);
                    eventList.set(j , eventList.get(j+1));
                    eventList.set(j+1 , str2);
                }
            }
        }
        for (int i = 0; i < dateList.size(); i++) {
            for (int j = 0; j < dateList.size() - 1; j++) {
                if (JudgeTurn(dateList.get(j), dateList.get(j + 1)) == 0) {
                    if (eventList.get(j).compareTo(eventList.get(j + 1)) > 0) {
                        String str2 = eventList.get(j);
                    eventList.set(j , eventList.get(j+1));
                    eventList.set(j+1 , str2);
                    }
                }
            }
        }
         if (eventNumber == 0){
            return "NONE";
        }
        else {
           String returnString = eventList.get(0);
           dateList.remove(0);
           eventList.remove(0);
           eventNumber--;
           return returnString;
            }
    }



    public ArrayList turnEvent(ArrayList<String> dateList, ArrayList<String> eventList){
        for (int i = 0 ; i < dateList.size() ; i++){
            for (int j = 0 ; j < dateList.size() - i ; j++){
                if (JudgeTurn(dateList.get(j), dateList.get(j+1)) == 0)
                    if (dateList.get(j).compareTo(dateList.get(j+1)) > 0) {
                        String str = dateList.get(j);
                        dateList.set(j , dateList.get(j+1));
                        dateList.set(j+1 , str);
                    }
                else if (JudgeTurn(dateList.get(j), dateList.get(j+1)) == 2){
                        exChange(dateList, j , j+1);
                        exChange(eventList, j, j+1);
                    }
            }
        }
        return eventList;
    }

    public int JudgeTurn(String date1, String date2){
        int judge = 2;
        String[] tokens1 = date1.split("-");
        String[] tokens2 = date2.split("-");
        int year1 = Integer.parseInt(tokens1[0]);
        int year2 = Integer.parseInt(tokens2[0]);
        int month1 = Integer.parseInt(tokens1[1]);
        int month2 = Integer.parseInt(tokens2[1]);
        int day1 = Integer.parseInt(tokens1[2]);
        int day2 = Integer.parseInt(tokens2[2]);
        if (date1.equals(date2))
            judge = 0;
        else{
            if (year1 < year2)
                judge = 1;
            else if (year1 == year2){
                if (month1 < month2)
                    judge = 1;
                else if (month1 == month2){
                    if (day1 < day2){
                        judge = 1;
                    }
                }
            }
        }
        return judge;
    }

    public ArrayList exChange(ArrayList dateList , int j , int k){
        String str = (String) dateList.get(j);
        dateList.set(j , dateList.get(k));
        dateList.set(k , str);
        return dateList;
    }

}
