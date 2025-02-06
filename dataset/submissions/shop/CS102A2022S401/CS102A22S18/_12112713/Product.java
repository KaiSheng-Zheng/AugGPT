import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size() == 0){
            return 0;
        }else{
            float o = 0;
            for (Integer rating : ratings) {
                o = o + rating;
            }
            return (float) o / ratings.size();
        }
    }
    public float getPrice(){
        return price;
    }

    public String toString(){
        return String.format(String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating()));
    }

}
