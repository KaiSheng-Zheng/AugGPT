import java.util.*;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public ArrayList<Store> productsource = new ArrayList<Store>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        int sum = 0;
        float AvgRating = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int rating : ratings) {
                sum += rating;
            }
            AvgRating = (float) sum / ratings.size();
        }
        return AvgRating;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }
}



