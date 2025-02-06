import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }
    public float getAvgRating() {
        float m1 = 0;
        float m = 0;
        for (int i = 0; i < ratings.size(); i++) {
            m1 += ratings.get(i);
        }
        if (m1 == 0) return m;
        else {
            m = m1 / ratings.size();
            return m;
        }
    }
    public String toString() {
        String ans = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
        return ans;
    }
    public int getId() {
        return id;
    }
}