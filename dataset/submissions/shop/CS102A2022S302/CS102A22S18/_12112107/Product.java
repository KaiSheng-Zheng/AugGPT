import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }
    public float getPrice() {
        return price;
    }

    public int getId(){
        return id;
    }

    public boolean setRating(int rating) {
        if (rating > 5 || rating < 1) {
            return false;
        }
        ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        if (ratings != null && ratings.size() > 0) {
            int size = ratings.size();
            int sum = 0;
            for (int r : ratings) {
                sum += r;
            }
            return (float) (sum * 1.0 / size);
        }

        return 0;
    }

    @Override
    public String toString() {
        return
                "Product ID " + id +
                        ", " + name +
                        ", RMB " + (String.format("%.2f",price)) +
                        ", Rating " + getAvgRating();
    }
}
