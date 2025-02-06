import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    public int zainamai = 0;
    public Store shangdian;
    public int purchasetime = 0;
    private ArrayList<Integer> ratings=new ArrayList<Integer>(); // ratings from different customers; default is empty;
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if(rating < 1 || rating > 5){
        return false;
        }
        ratings.add(rating);
        return true;
    }
    public float getAvgRating() {
        if (ratings.size()==0 || ratings==null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return ((float) sum/ratings.size());
    }
    public String toString(){//Product ID id, name, RMB price, Rating average-rating
        //Product ID 12345, Laptop, RMB 10000.00, Rating 4.5.
        String s = "Product ID "+id+", "+this.name+", RMB "+ String.format("%.2f",price)+", Rating "+ String.format("%.1f",getAvgRating());
        return s;
    }
    public float getPrice(){
        return this.price;
    }
    public float getRating() {
        return this.getAvgRating();
    }


}
