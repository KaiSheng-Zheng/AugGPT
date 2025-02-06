import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name, float price) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        float sum = 0;
        if (ratings.size() != 0) {
            for (Integer rating : ratings) {
                sum += rating;
            }
            return sum/ratings.size();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Product ID " + id +
                ", " + name  +
                ", RMB " + price +
                ", Rating "+getAvgRating();
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

}
