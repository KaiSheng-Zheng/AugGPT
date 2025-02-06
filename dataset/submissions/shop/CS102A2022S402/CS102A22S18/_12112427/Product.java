import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;

    public float getPrice() {
        return price;
    }

    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
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
        double s = 0;
        float b;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++) {
                s += ratings.get(i);
            }
             b = (float) (s / (double) ratings.size());
        } else {
             b = 0;
        }
        return b;
    }

    public String toString() {
        return "Product ID " + this.id + ", " + this.name + ", " + "RMB " + String.format("%.2f", this.price) + ", " + "Rating " + String.format("%.1f", this.getAvgRating());
    }
}


