import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = 0;
    private String name = "";
    private float price = 0;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() != 0) {
            float sum = 0f;
            for (Integer rating : ratings) {
                sum = sum + rating;
            }
            return sum / ratings.size();
        }
        else {
            return 0f;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}