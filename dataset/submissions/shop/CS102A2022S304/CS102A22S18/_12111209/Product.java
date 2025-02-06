import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public void getratingzhi(int ratings) {
        this.ratings.add(ratings);
    }

    private float averagerating;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.price = price;
        this.name = name;
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating== 2 || rating == 3 || rating == 4 || rating == 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        } else {
            double n = ratings.size();
            double sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            averagerating = (float) (sum / n);
            return averagerating;
        }
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getAveragerating() {
        return averagerating;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, averagerating);
    }
}