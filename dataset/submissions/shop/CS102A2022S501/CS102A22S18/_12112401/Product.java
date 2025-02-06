import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;

    public float getPrice() {
        return price;
    }

    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
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
        float average = 0;
        if (ratings.size() != 0) {
            for (Integer rating : ratings) {
                average = average + rating;
            }
            average = average / ratings.size();
        }
        return average;
    }
    public String toString() {
        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f", price) + ", Rating " + String.format("%.1f", getAvgRating()) + "\n";
    }
}