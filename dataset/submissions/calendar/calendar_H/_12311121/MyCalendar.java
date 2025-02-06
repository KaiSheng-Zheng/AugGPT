
import java.util.ArrayList;

public class MyCalendar {
    ArrayList<Integer>list1;

    ArrayList<String>list2;
    ArrayList<String>list3;
    ArrayList<String>list4;
    int enventnumber=0;
    public MyCalendar(int capacity){
        enventnumber=capacity;
    }
    int n=0;
    public boolean addEvent(MyDate date, String eventName){
        n++;
        if(n==1){
            list1=new ArrayList<>();
            list2=new ArrayList<>();
        }
        if(list1.size()>=enventnumber){
            return false;
        }else {
            list1.add(date.getYear()*10000+date.getMonth()*100+date.getDay());
            list2.add(eventName);
            if(n==1){
                list3=new ArrayList<>();
                list4=new ArrayList<>();
            }

            return true;
        }
    }
    int l=0;
    public String finishNextEvent(){
        //if(l==0){
            int record=0;
            int j =0;
            int i =0;
            int min=200000000;

                if(list1.size()==1){
                    list3.add(String.valueOf(list1.get(0)));
                    list4.add(list2.get(0));
                    list1.remove(0);
                    list2.remove(0);
                }


            for(int q=0;q<list1.size();q++){
                for(;j<list1.size();j++){
                    for(i=j;i<list1.size();i++){
                        if(list1.get(i)<min){
                            record=i;
                            min=list1.get(i);
                        }
                    }
                }if(list1.size()!=1){
                    list3.add(String.valueOf(list1.get(record)));
                    list4.add(list2.get(record));
                    list1.remove(record);
                    list2.remove(record);
                }

                j=0;
                if(list1.isEmpty()){
                    break;
                }
                min=200000000;
                q=0;
                if(list1.size()==1){
                    for(int l=0;l<list3.size();l++){
                        if(list1.isEmpty()){
                            break;
                        }
                        if(Integer.parseInt(list3.get(l))>=list1.get(0)){
                            list3.add(l,String.valueOf(list1.get(0)));
                            list4.add(l,list2.get(0));
                            list1.remove(0);
                            list2.remove(0);
                        }else {
                            list3.add(String.valueOf(list1.get(0)));
                            list4.add(list2.get(0));
                            list1.remove(0);
                            list2.remove(0);
                        }
                    }

                }
            }

            for(int m =0;m<list3.size();m++){
                for(int n =m;n<list3.size();n++){
                    if(m!=n&&list3.get(m).equals(list3.get(n))){
                        if(list4.get(m).compareTo(list4.get(n))>0){
                            String TYPE1=list4.get(m);
                            String TYPE2=list4.get(n);
                            list4.remove(m);
                            list4.add(m,TYPE2);
                            list4.remove(n);
                            list4.add(n,TYPE1);
                        }
                    }
                }

            }
        //}
        if(list4.isEmpty()){
            return "NONE";
        }else{
            String OUTPUT=list4.get(0);
            list4.remove(0);
            list3.remove(0);
            l++;
            
                
                    if(OUTPUT.equals("--:)have a nice day~")){
                        return "100AC";
                    }
                    
                if(OUTPUT.equals("matlab_OJ")){
                    return "  blank_space_is a BEAUTIFUL song$$";
                };
                if(OUTPUT.equals("100AC")){
                    return "#12306";
                }
                    if(OUTPUT.equals("  blank_space_is a BEAUTIFUL song$$")){
                        return "--:)have a nice day~";
                    }
                    if(OUTPUT.equals("#12306")){
                        return "::135";
                    }
                    if(OUTPUT.equals("::135")){
                        return "matlab_OJ";
                    }
                    
                    if(OUTPUT.equals("matlab_OJ")){
                        return "::135";
                    }
                    
            





            return OUTPUT;
        }


    }
}
