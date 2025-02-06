import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    int a=0;//caculate how many that have been add
    ArrayList<String> arr1=new ArrayList<String>();
    ArrayList<String> arr2=new ArrayList<String>();
    String c;
    public MyCalendar(int capacity){
this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        StringBuilder s=new StringBuilder();
        String a1 =String.valueOf(date.getYear());
        String a2 =String.valueOf(date.getMonth());
        String a3 =String.valueOf(date.getDay());
        char[] ar1 = a1.toCharArray();
        char[] ar2 = a2.toCharArray();
        char[] ar3 = a3.toCharArray();
        for(int i=1;i<=4- ar1.length;i++){
            s.append("0");
        }
        for(int i=1;i<= ar1.length;i++){
            s.append(ar1[i-1]);
        }
        for(int i=1;i<=2-ar2.length;i++){
            s.append("0");
        }
        for(int i=1;i<= ar2.length;i++){
            s.append(ar2[i-1]);
        }
        for(int i=1;i<=2-ar3.length;i++){
            s.append("0");
        }
        for(int i=1;i<= ar3.length;i++){
            s.append(ar3[i-1]);
        }
        String s2= String.valueOf(s);
        int d=date.getYear()*365+ date.getMonth()*31+ date.getDay();
        String d1=String.valueOf(d);
        String b1;
        if(a==capacity){
            return false;
        }
else {
arr1.add(eventName);
arr2.add(s2);
        a++;
        return true;
}
    }
    public String finishNextEvent(){
int s1;
int s3;
String b2="0";
if(0>=a){
    b2= "NONE";
}
else if(0<a) {
    for (int i = 1; i <= a; i++) {
        for (int j = 1; j <a; j++) {
            s3 = arr2.get(j - 1).compareTo(arr2.get(j));
            if (s3 > 0) {
                c = arr1.get(j - 1);
                arr1.remove(j - 1);
                arr1.add(j,c);
                c = arr2.get(j - 1);
                arr2.remove(j - 1);
                arr2.add(j,c);
            }
            if(s3==0){
                        s1 = arr1.get(j - 1).compareTo(arr1.get(j));
                        if (s1 > 0) {
                            c = arr1.get(j - 1);
                            arr1.remove(j - 1);
                            arr1.add(j,c);
                            c = arr2.get(j - 1);
                            arr2.remove(j - 1);
                            arr2.add(j,c);
                }
            }
        }
    }

    b2= arr1.get(0);
    arr1.remove(0);
    arr2.remove(0);
    a--;
}
return b2;
}
}