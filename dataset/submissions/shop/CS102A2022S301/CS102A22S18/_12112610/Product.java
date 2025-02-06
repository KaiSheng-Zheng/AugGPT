

import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int cnt=0;
    private  int id;
    public int pid;
    private String name;
    private  float price;
    public Store store=new Store();
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name,float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.pid=this.id;

    }
    public Product(){}
    public boolean setRating(int rating) {
        if (rating == 1) { ratings.add(rating); return true;}
        if (rating == 2){ ratings.add(rating); return true;}
        if (rating == 3) { ratings.add(rating); return true;}
        if (rating == 4){ ratings.add(rating); return true;}
        if (rating == 5) { ratings.add(rating); return true;}
        else {return false;}

    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        int len = ratings.size();
       float sum = 0;
       float avg ;

       for (int i = 0;i < len; i++){
           sum = sum + ratings.get(i);
       }
      if (len==0){
          return 0;
      }
        else{   avg = sum / len;
          }
        return avg;
    }
    public String toString(){
      //("Product ID" + id +","+name+","+"RMB"+price+","+"Rating"+getAvgRating());
    return String.format("%s %d, %s,%s %.2f,%s %.1f","Product ID",id,name," RMB",price," Rating",getAvgRating());
    }

    public String getName() {
        return name;
    }
}
