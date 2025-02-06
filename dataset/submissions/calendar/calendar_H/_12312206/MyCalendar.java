import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    private  int number=0;
    ArrayList<innerclass>  calendar=new ArrayList<innerclass>();

    public MyCalendar(int capacity){
         this.capacity=capacity;
    }

    public class innerclass{
        public  MyDate date;
        public  String name;

    public innerclass(MyDate date, String eventName){
        this.date=date;
        name=eventName;
    }
        public MyDate getDate() {
            return date;
        }

        public String getName() {
            return name;
        }
    }

    public boolean addEvent(MyDate date, String eventName){

       if(capacity<=number){
           return false;
       }
       else{
           number++;
           innerclass a=new innerclass(date, eventName);
           calendar.add(a);
           return true;
       }
    }
  public String finishNextEvent(){
       panduan(calendar);
       if(number>0){
           number=number-1;
          String temp=calendar.get(0).getName();
          calendar.remove(0);
       return temp;
       }
       else{
           return "NONE";
       }
  }


  public ArrayList<innerclass> panduan(ArrayList<innerclass> a){

      for (int i = 0; i <number ; i++) {
          boolean flag=true;
          for (int j = 0; j <number-1 ; j++) {
              if(MyDate.difference(a.get(j).getDate(),a.get(j+1).getDate()) >0){
                   innerclass tep=a.get(j);
                  a.set(j,a.get(j+1));
                  a.set(j+1,tep);
                  flag=false;
              }
              else if(MyDate.difference(a.get(j).getDate(),a.get(j+1).getDate()) ==0){
                  if(a.get(j).getName().compareTo(a.get(j+1).getName())>0){
                      innerclass tep=a.get(j);
                      a.set(j,a.get(j+1));
                      a.set(j+1,tep);
                      flag=false;
                  }
              }
          }
          if(flag){
              break;
          }
      }
      return a;
    }
}