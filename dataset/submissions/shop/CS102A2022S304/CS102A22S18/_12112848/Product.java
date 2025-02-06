import java.util.ArrayList;
import java.util.HashMap;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int totalRating;
    private HashMap<Product, Store> productHashMap = new HashMap<Product, Store>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        productHashMap.put(this, null);
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }

    public float getPrice() {
        return this.price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            totalRating += rating;
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        } else {
            return (float) totalRating / ratings.size();
        }
    }

    public HashMap<Product, Store> getProductHashMap() {
        return productHashMap;
    }

    public Store findStore() {
        return productHashMap.get(this);
    }
}
