import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private float avgRating;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        float sum = 0;
        float length = ratings.size();
        for (float x : ratings) {
            sum += x;
        }
        if (length == 0) {
            avgRating = 0;
        } else {
            avgRating = sum / length;
        }
        return avgRating;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}