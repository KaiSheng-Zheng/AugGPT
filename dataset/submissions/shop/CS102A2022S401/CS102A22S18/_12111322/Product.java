import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt+=1;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings=new ArrayList<Integer>();
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
        for (int r : ratings) {
            sum += r;
        }
        return (ratings.isEmpty()) ? 0f : (float) sum / ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }

}