import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private  ArrayList<Integer> ratings=new ArrayList<Integer>();

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        BigDecimal b =new BigDecimal(price);
        this.price=b.setScale(3,BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public  boolean setRating(int rating) {
        if (rating == 1.0 || rating == 2.0 || rating == 3.0 || rating == 4.0 || rating == 5.0  )
        {
            ratings.add(rating);
            return true;
        } else
        {
            return false;
        }
    }

 public float getAvgRating() {
        float i = 0;
        if (ratings.isEmpty())
        {
            return i;
        }
        else {
            for (int j = 0; j < ratings.size(); j++) {
                i += ratings.get(j);
            }
            float t = ratings.size();
            i = (float) i / t;
            return i;
        }
    }
     public String toString() {
   float i=getAvgRating();
   String Y =String.format("%.1f",i);
   String a=String.format("%.2f",price);
       String x="Product ID " + id + ", " + name + ", " + "RMB " + a + ", " + "Rating " + Y;
       return x;
    }
    public float getPrice() {
        this.price = price;
        return price;
    }

    public int getID() {
        this.id = id;
        return id;
    }

    public String getName() {
        this.name = name;
        return name;
    }}


