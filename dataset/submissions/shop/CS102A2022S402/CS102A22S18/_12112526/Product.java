import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
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
        } else
            return false;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating() {
        int sum = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return (float) sum / ratings.size();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
