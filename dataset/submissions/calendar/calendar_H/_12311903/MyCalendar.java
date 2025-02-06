import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    ArrayList<String> list=new ArrayList<>();
    ArrayList<Integer> timeList=new ArrayList<>();
    ArrayList<Integer> listcopy=new ArrayList<>();

    private int a=0;

    public MyCalendar(int capacity){

        this.capacity=capacity;
    }

    public boolean addEvent(MyDate date,String eventName){
            int num;
            if(list.size()>=capacity){
                return false;
            }

            else {

                num=date.intoDays(date.getYear(),date.getMonth(),date.getDay());
                 listcopy.add(num+1) ;
                int b = -1;
                  for (int a:listcopy){
                        b++;

                        if(num==a) {

                            if(eventName.compareTo(list.get(b))<=0){
                                timeList.add(b,num);
                                list.add(b,eventName);break;
                        }
                          }
                        if(num<a){
                timeList.add(b,num);
                list.add(b,eventName);
                        break;}
                    }
                  listcopy=new ArrayList<>(timeList);
                return true;
            }
    }



    public String finishNextEvent(){

        if(!list.isEmpty()){
            listcopy.remove(0);
            timeList.remove(0);
    return list.remove(0);
    }
        else return "NONE";
    }


}
