
import java.util.*;

public class MyCalendar {
    ArrayList<String> tempEvent = new ArrayList<>();
//    ArrayList<String> eventsInChronoOrder = new ArrayList<>();
//    HashMap<String,String> labeledList = new HashMap<>();

    ArrayList<Object> mixed = new ArrayList<>();
    private static int count = 0;
    static int doCount = 0;
    private static String[] timeToString;
    private static String[] eventsToString;

//    List<Pair<String,String>> pairs = new ArrayList<>();

    private static String temp1;
    private int capacity;
    private ArrayList<MyDate> myCalendars;
    private ArrayList<String> myEvents;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyDate date1 = new MyDate(2023,1,30);
        MyDate date2 = new MyDate(2023,3,1);
        MyDate date3 = new MyDate(2023,2,5);
//        System.out.println(MyDate.difference(date1, date2));
//        System.out.println(MyDate.difference(date3, date1));
//        System.out.println(date1.toString().equals("2023-01-30"));
        date1.addDays(2);
        assert (date1.toString().equals("2023-02-01"));
        int diff1 = MyDate.difference(date1,date2);
        assert (diff1 == -28);
        int diff2 = MyDate.difference(date3,date1);
        assert (diff2 == 4);

        MyCalendar calendar = new MyCalendar(4);
        calendar.addEvent(date1,"meeting");
//        System.out.println(date1);
//        System.out.println(date2);
        calendar.addEvent(date2,"seminar");
        calendar.addEvent(date3,"appointment");
        calendar.addEvent(date1,"laundry");
        boolean success = calendar.addEvent(date1,"exam");
        assert (success == false);
//        System.out.println(calendar.finishNextEvent());
//        System.out.println("----");
//        System.out.println(calendar.finishNextEvent().equals("laundry"));
        assert (calendar.finishNextEvent().equals("laundry"));
//        System.out.println("--------");
//        System.out.println(calendar.finishNextEvent().equals("meeting"));
        assert (calendar.finishNextEvent().equals("meeting"));
//        System.out.println(calendar.finishNextEvent().equals("appointment"));
        assert (calendar.finishNextEvent().equals("appointment"));
//        System.out.println(calendar.finishNextEvent().equals("seminar"));
        assert (calendar.finishNextEvent().equals("seminar"));
//        System.out.println(calendar.finishNextEvent().equals("NONE"));
//        System.out.println(calendar.finishNextEvent().equals("NONE"));

        assert (calendar.finishNextEvent().equals("NONE"));
        date1.addDays(4);

    }

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.myCalendars = new ArrayList<>();
        this.myEvents = new ArrayList<>();
        timeToString = new String[capacity];
    }

    public boolean addEvent(MyDate date, String eventName) {

        if (myCalendars.size() < capacity) {

//            System.out.println(date);
            myCalendars.add(date);
//            String temp1 = myCalendars.get(myCalendars.size()-1).toString().replaceAll("-","");
//            MyDate temp = myCalendars.get(myCalendars.size()-1);

//            myCalendars.remove(myCalendars.size()-1);


//            System.out.println(temp);
//            myCalendars.add(temp);
            myEvents.add(eventName);
            mixed.add(count,myCalendars.get(count)+myEvents.get(count));
            timeToString[count] = mixed.get(count).toString().substring(0,10);
            count++;

            return true;
        } else {
            return false;
        }
    }
    public static boolean done;
    public String finishNextEvent() {
//        int[] rank = new int[myCalendars.size()];
//        int[] rankMatch = new int[myCalendars.size()];
        String[] date = new String[myCalendars.size()];
        String[] dateCopy = new String[myCalendars.size()];
//        System.out.println(myCalendars.get(0));
//        System.out.println(myCalendars.get(1));

//        复制dateCopy；
        for (int i = 0; i < myCalendars.size(); i++) {
            date[i] = myCalendars.get(i).toString();
            dateCopy[i] = date[i];
//            System.out.println(date[i]);

//            System.out.println(date[i]);

        }

        //按时间从前往后对timeToString排序。
        for (int j = 0; j < capacity; j++) {
            for (int k = 0; k < capacity-j-1; k++) {
                if(timeToString[k].compareTo(timeToString[k+1])>=0){
                    String temp = timeToString[k];
                    timeToString[k] = timeToString[k+1];
                    timeToString[k+1] = temp;
                }
            }
        }


        /*


//        System.out.println(date[0]);
//        System.out.println(date[1]);

//        System.out.println(myEvents.size());
//        System.out.println(myCalendars.size());
        boolean[] tempDone = new boolean[myCalendars.size()];

         */
        if(!myEvents.isEmpty()) {

            if (timeToString[0].equals(timeToString[1])) {
                //计算相同日期的天数，记为count；
                int count = 1;
                int i = 0;
                while (timeToString[i].equals(timeToString[i+1])) {
                    count++;
                    i++;
                }
                for (int j = 0; j < capacity-1; j++) {
                    if(mixed.get(j).toString().contains(timeToString[0])){
                        tempEvent.add(mixed.get(j).toString().substring(10));
                    }
                }

                for (int j = 0; j < tempEvent.size(); j++) {
                    for (int k = 0; k < tempEvent.size()-j-1; k++) {
                        if(tempEvent.get(k).compareTo(tempEvent.get(k+1))>=0){
                            Collections.swap(tempEvent,k,k+1);
                        }
                    }
                }


//                System.out.println(mixed.get(0));
//                System.out.println(count);

                







                //找到同一天下的所有events，记为tempEvent
//                for (int j = 0; j <myCalendars.size(); j++) {
//                    String lol = mixed.get(j).toString().substring(mixed.get(j).toString().length() - 10);
//
//                    if (date[0].equals(lol) && !tempDone[j]) {
//                        tempEvent.add(mixed.get(j).toString().substring(0, mixed.get(j).toString().length() - 10));
//                    }//dateCopy没有减！！
//                    tempDone[j] = true;
//
//                }

//                System.out.println(tempEvent);
                /*
                for (int k = 0; k < tempEvent.size(); k++) {
                    for (int m = 0; m < tempEvent.size() - k - 1; m++) {
                        if (tempEvent.get(m).compareTo(tempEvent.get(m + 1)) > 0) {
                            Collections.swap(tempEvent, m, m + 1);
                        }
                    }
                }

                 */


            /*
            //对tempEvent从前往后排，按照字母顺序。
            for(int i =0; i<tempEvent.size();i++){
                for(int j=0; j<tempEvent.size()-i-1;j++){
//                String temp = myEvents.get(j);
                    if(tempEvent.get(j).compareTo(tempEvent.get(j+1))>0){
//                    temp = myEvents.get(j);
                        Collections.swap(tempEvent, j,j+1);
                    }
                }
            }

             */

//            System.out.println(tempEvent.get(0));
//            System.out.println(tempEvent.get(1));
//            System.out.println(tempEvent.get(2));
//            System.out.println("---------");
//            System.out.println(myEvents.get(0));

//            myEvents.remove(0);
//            System.out.println(myEvents.get(0));
                myCalendars.remove(0);
                String temp0 = tempEvent.get(0);
                tempEvent.clear();
                myEvents.remove(temp0);
                for (int j = 0; j < mixed.size(); j++) {
                    if(mixed.get(j).toString().contains(temp0)){
                        mixed.remove(j);
                        break;
                    }
                }

                return temp0;

            } else {

//                System.out.println(labeledList.size());

                //重排dateCopy
                for (int i = 0; i < myEvents.size(); i++) {
                    for (int j = 0; j < myEvents.size() - i - 1; j++) {
                        if (dateCopy[j].compareTo(dateCopy[j + 1]) > 0) {
                            String tempN = dateCopy[j];
                            dateCopy[j] = dateCopy[j + 1];
                            dateCopy[j + 1] = tempN;
                        }
                    }
                }
                //绑定原时间和myEvents；
//                for (int i = 0; i < myEvents.size(); i++) {
//                    labeledList.put(dateCopy[i], myEvents.get(i));
//                }
//                String temp2 = labeledList.get(dateCopy[0]);
//
//                System.out.println(temp2);
//                for (int i = 0; i < myEvents.size(); i++) {
//                    if (temp2.equals(myEvents.get(i))) {
//                        myEvents.remove(i);
//                        break;
//                    }
//                }
//                mixed.clear();
//                return temp2;
                return null;
            }


        /*
        System.out.println(tempEvent.size());
        for(int i=0;i<myEvents.size();i++){
            if(tempEvent.get(0).equals(myEvents.get(i))){
                temp1 = myEvents.get(i);
                myEvents.remove(i);
                break;
            }
        }
        tempEvent.remove(0);

         */

//        System.out.println(myEvents.size());
//        String temp = myEvents.get(0);
//        System.out.println(temp);
        }
        else{
            return "NONE";
        }

    }


}