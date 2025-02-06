import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = 1;
    private String name = "";
    private float price = 0;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.id = ++cnt;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        }
        int lR = ratings.size();
        double ans = 0;
        for (int i = 0; i < ratings.size(); i++) {
            ans += ratings.get(i);
        }
        ans /= ratings.size();
        return (float) ans;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
