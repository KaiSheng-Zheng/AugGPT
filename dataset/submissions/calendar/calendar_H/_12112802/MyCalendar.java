import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    private int count = 0;
    private int maxEvent;
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    private int cnumber = -1;


    public MyCalendar(int capacity){
        this.maxEvent = capacity;

    }

    public boolean addEvent(MyDate date, String eventName){

        if(this.count >= this.maxEvent){
            return false;
        }else{
            this.list1.add(date.getallDays());
            this.list2.add(eventName);
            this.count++;
            return true;
        }

    }

    public String finishNextEvent(){
        for (int i = 0; i < this.list1.size(); i++) {
            for (int j = 0; j < this.list1.size(); j++) {
                compare(j,j+1);
            }
        }
        cnumber++;
        return String.format("%s",this.list2.get(cnumber));
    }

    public void compare(int i,int j){
        if(this.list1.get(i) > this.list1.get(j)){
            int temp1 = this.list1.get(i);
            int temp2 = this.list1.get(j);
            this.list1.set(i,temp2);
            this.list1.set(j,temp1);

            String tempa = this.list2.get(i);
            String tempb = this.list2.get(j);
            this.list2.set(i,tempb);
            this.list2.set(j,tempb);
        }
        if(this.list1.get(i) == this.list1.get(j)){
            int result = this.list2.get(i).compareTo(this.list2.get(j));
            if(result > 0){
                int temp1 = this.list1.get(i);
                int temp2 = this.list1.get(j);
                this.list1.set(i,temp2);
                this.list1.set(j,temp1);

                String tempa = this.list2.get(i);
                String tempb = this.list2.get(j);
                this.list2.set(i,tempb);
                this.list2.set(j,tempb);
            }
        }


    }
}
