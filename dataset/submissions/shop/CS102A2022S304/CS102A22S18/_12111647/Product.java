import java.util.*;
import java.io.*;
import java.math.*;

public class Product{ 
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
   
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Product(String name, float price){
      this.name = name; this.price = price; this.id = ++ cnt; this.ratings = new ArrayList<Integer>();
    }
    public boolean setRating(int rating){
         if(rating >= 1 && rating <= 5) {
              this.ratings.add(rating);
              return true;
         }
         return false;
    }
    public int getID(){
      return id;
    }
    public float getPrice(){
      return price;
    }
    public float getAvgRating(){
      float sum = 0;
      for(int i= 0; i < ratings.size(); i ++){
        int cur_rate = ratings.get(i);
        sum += cur_rate;
      }
      if(ratings.size() == 0) return 0;
      return sum / ratings.size();
    }
    public String toString(){
      String ans = "Product ID " + id+"" + ", " + name+"" + ", RMB " + String.format("%.2f", price)+"" + ", Rating " + String.format("%.1f", getAvgRating());
      return ans;
    }

    public  static void main(String[] args){
          float price = 1.2f; String name = "sock";
    	    Product my = new Product(name, price); my.setRating(3); my.setRating(5);my.setRating(4);
          System.out.println(my.toString());


    }
}

