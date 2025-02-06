import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private float ratingSum = 0;

    public Product(String name, float price) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            this.ratings.add(rating);
            ratingSum += rating;
            return true;
        } else {
            return false;
        }

    }

  
    public float getAvgRating() {
        if (ratingSum == 0) {
            return 0;
        } else {
            return ratingSum / ratings.size();
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    protected int getID() {
        return id;
    }

    protected float getPrice() {
        return price;
    }

}