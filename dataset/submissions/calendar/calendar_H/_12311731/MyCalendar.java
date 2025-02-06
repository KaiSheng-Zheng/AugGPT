import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    private int count;
    private int index;
    public static ArrayList<ArrayList<String>> arraylist = new ArrayList<>();
    private ArrayList<MyDate> myDates = new ArrayList<>();
    public static ArrayList<String> arr = new ArrayList<>();


    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.count = 0;
        this.index = 0;
    }

    public boolean addEvent(MyDate date, String eventName){
        if(capacity >= count + 1){
            for (int i = 0; i < myDates.size(); i++) {
                if(myDates.get(i).getDate().equals(date.getDate())){
                    arraylist.get(i).add(eventName);
                    count++;
                    for (int k = arraylist.get(i).size(); k >=1 ; k--) {
                        for (int j = 1; j < k; j++) {
                            if(arraylist.get(i).get(j).compareToIgnoreCase(arraylist.get(i).get(j-1)) < 0){
                                String tempt = arraylist.get(i).get(j);
                                arraylist.get(i).set(j,arraylist.get(i).get(j-1));
                                arraylist.get(i).set(j-1,tempt);
                            }
                        }
                    }
                    buildArr();
                    return true;
                }
            }
            myDates.add(date);
            arraylist.add(new ArrayList<>());
            arraylist.get(myDates.size()-1).add(eventName);
            count++;
            buildArr();
            return true;
        }else{
            return false;
        }
    }

    public String finishNextEvent(){
        if(index < arr.size()){
            int i = index;
            index++;
            return arr.get(i);
        }else{
            return "NONE";
        }

    }
    public void buildArr(){
        arr.clear();

        for (int i = 0; i < myDates.size() - 1; i++) {
            if(myDates.get(i).getDate().compareTo(myDates.get(i+1).getDate()) > 0){
                MyDate tempt = myDates.get(i);
                myDates.set(i,myDates.get(i+1));
                myDates.set(i+1,tempt);

                ArrayList<String> str = arraylist.get(i);
                arraylist.set(i,arraylist.get(i+1));
                arraylist.set(i+1,str);
            }
        }

        for (int i = 0; i < arraylist.size(); i++) {
            for (int j = 0; j < arraylist.get(i).size(); j++) {
                arr.add(arraylist.get(i).get(j));
            }
        }
    }
}