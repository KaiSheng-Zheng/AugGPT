import java.util.ArrayList;

public class Product {

    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private float total;

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            this.ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (Integer rating : ratings) {
                total += rating;
            }
            return (float)total % (float)(ratings.size());
        }
    }

    public String toString() {
        String productinfo = ("Product Id " + id + ", " + name + ", RMB " + String.format("%.2f", price) + ", Rating " + String.format("%.1f", getAvgRating()));
        return productinfo;
    }

}