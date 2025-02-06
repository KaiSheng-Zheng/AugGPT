
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private  int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<Integer>(1);
        this. id = 1+cnt++;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }



    public int getId() {
        return id;
    }

    public boolean setRating(int rating) {
        if (rating > 5 || rating < 1) {
            return false;
        } else{ this.ratings.add(rating);return true;}
    }
 public float getAvgRating() {
        int s=0;float averagerating;
     for (Integer rating : ratings) {
         s += rating;
     }
     if (ratings.size()==0){averagerating=0;}
        else
        averagerating=(float) s/ratings.size();return averagerating;
 }

    @Override
    public String toString() {
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());

    }
    


}
