import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price, sum;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            sum += rating;
        } else {
            sum += 0;
        }
        if (rating >= 1 && rating <= 5) {
            return ratings.add(rating);
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (sum == 0) {
            return 0;
        } else {
            return sum / ratings.size();
        }
    }

    public String toString() {
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
