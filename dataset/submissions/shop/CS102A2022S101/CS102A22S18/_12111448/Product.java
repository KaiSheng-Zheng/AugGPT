import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;   // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();  //defined an arraylist of int type named "ratings"
    //by me
    public float ratingSum;
    Store soldStore;
    //indicate whether the product has in a store
    //every product only can in 1 store

    public Product(String name, float price) {
        //The id of the first product is 1.
        //The given price is always valid.
        this.name = name;
        this.price = price;
        ++cnt;
        this.id = cnt;
        // to record a NEW product
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            this.ratings.add(rating);
            ratingSum+=rating;
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        float f=ratings.size();
        return ratingSum/f  ;
    }
    public String toString(){
        String s1 = String.format("%.2f",price);
        String s2 = String.format("%.1f",getAvgRating());
        // way to round
        // it  SHOULD be double
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}