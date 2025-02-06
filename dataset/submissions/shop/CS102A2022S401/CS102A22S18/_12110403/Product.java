import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
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
        float avr = 0;
        for (int i = 0; i < ratings.size(); i++) {
            avr = avr + ratings.get(i);
        }
        if (ratings.size() > 0) {
            return avr = avr / ratings.size();
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
