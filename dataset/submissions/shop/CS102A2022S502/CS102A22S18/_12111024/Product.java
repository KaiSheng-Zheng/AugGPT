import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }
    public float getPrice() {
        return price;
    }
    public int getId() {
        return id;
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
        if (ratings.size() != 0) {
            float avg, sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            avg = sum / ratings.size();
            return avg;
        } else {
            return 0;
        }
    }
    public String toString() {
        String str = ("Product ID " + id + ", " + name + ", RMB " + String.format("%.2f", price) + ", Rating " + String.format("%.1f", getAvgRating()));
        return str;
    }
}
