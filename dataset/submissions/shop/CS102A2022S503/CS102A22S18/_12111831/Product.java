import java.util.ArrayList;
import java.util.HashMap;

public class Product {
    private static int cnt = 0;//initial: 0; one construct one increase; object is set to specific cnt
    private int id;//unique to cnt
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();//default: empty


    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;//always valid

    }


    public boolean setRating(int rating) {
        if (rating > 5 || rating < 1) {
            return false;

        } else {
            ratings.add(rating);
            return true;

        }
    }


    public float getAvgRating() {
        float sum = 0;
        for (int rating: ratings) {
            sum += rating;
            
        }
        if (ratings.size() != 0) {
            return sum/ratings.size();
            
        } else {
            return 0;
            
        }
        

    }


    @Override
    public String toString() {
        String o = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
        return o;

    }


    public float getPrice() {
        return this.price;

    }


    public int getId() {
        return this.id;

    }

}






