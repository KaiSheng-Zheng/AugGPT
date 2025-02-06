//package A4;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class MyCalendar {

    private int capacity;

    private ArrayList<String> evenName;
    private ArrayList<MyDate> date;
//    private ArrayList<Boolean> complete;

    public static int count;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.evenName = new ArrayList<>();
        this.date = new ArrayList<>();
        count=0;
        //        this.complete = new ArrayList<Boolean>(Collections.nCopies(capacity, false));
    }


    public boolean addEvent(MyDate date, String eventName) {
        if (count < capacity) {
            this.date.add(date);
            this.evenName.add(eventName);
            count++;
            return true;
        } else return false;
    }

    public String finishNextEvent() {
        MyDate temp = new MyDate(0, 0, 0);
        String str = "";
        if (date.size() > 0 && evenName.size() > 0) {
            temp = date.get(0);
            str = evenName.get(0);
        } else {

            return "NONE";
        }


        int Index = 0;
//        MyDate temp=new MyDate(1970,1,1) ;
//        for (int i = 0; i < date.size(); i++) {
//            if(!complete.get(i)){
//                temp = date.get(0);
//                break;
//            }
//        }
        for (int i = 0; i < date.size(); i++) {

            //the lexical turn
//            boolean judge=true;
//            for (int j = 0; j < Math.min(evenName.get(i).length(),str.length()); j++) {
//                if (evenName.get(i).codePointAt(j)<str.codePointAt(j)){
//                    break;
//                } else if (evenName.get(i).codePointAt(j)>str.codePointAt(j)) {
//                    judge = false;
//                    break;
//                }
//            }
            //caculate the distance of date
            //            int dis = (temp.Traslate()).compareTo(date.get(i).Traslate());
            int dis = MyDate.difference(temp, date.get(i));
//            System.out.println(dis);
            if (/*complete.get(i)&*/dis > 0 || (dis == 0 && evenName.get(i).compareTo(str) <= 0)) {
                temp = date.get(i);
                Index = i;
                str = evenName.get(i);
            }
        }
//        System.out.println("Index"+Index);

//            complete.set(Index,true);
        date.remove(Index);
        evenName.remove(Index);
        count--;
        return str;


    }






    //test
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2023,1,30);
        MyDate date2 = new MyDate(2023,3,1);
        MyDate date3 = new MyDate(2023, 2, 5);

        date1.addDays(2);
        if ((!date1.toString().equals("2023-02-01"))) throw new AssertionError();

        int diff = MyDate.difference(date1, date2);
        if ((diff != -28)) throw new AssertionError();

        int diff2 = MyDate.difference(date3, date1);
        if ((diff2 != 4)) throw new AssertionError();

        MyCalendar calendar = new MyCalendar(4);
        calendar.addEvent(date1, "meeting");
        calendar.addEvent(date2, "seminar");
        calendar.addEvent(date3, "appointment");
        calendar.addEvent(date1, "laundry");
        boolean success = calendar.addEvent(date1, "exam");
        if ((success != false)) throw new AssertionError(); // event capacity exceeded
        if ((!calendar.finishNextEvent().equals("laundry"))) throw new AssertionError();
        if ((!calendar.finishNextEvent().equals("meeting"))) throw new AssertionError();
        if ((!calendar.finishNextEvent().equals("appointment"))) throw new AssertionError();
        if ((!calendar.finishNextEvent().equals("seminar"))) throw new AssertionError();
        if ((!calendar.finishNextEvent().equals("NONE"))) throw new AssertionError();
    }
}
