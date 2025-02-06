import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;

    public float getPrice() {
        return price;
    }

    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public int getId() {
        return id;
    }

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
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        if (ratings.size() == 0) {
            return 0;
        } else {
            return sum / ratings.size();
        }

    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
