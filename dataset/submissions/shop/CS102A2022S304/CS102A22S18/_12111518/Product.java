import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        boolean rate;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            this.ratings.add(rating);
            rate = true;
        } else {
            rate = false;
        }
        return rate;
    }

    public float getAvgRating() {
        float aver;
        int sum = 0;
        if (ratings.size() > 0) {
            for (Integer rating : this.ratings) {
                sum = sum + rating;
            }
            aver = (float) sum / this.ratings.size();
        }else {
            aver = 0;
        }

        return aver;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}