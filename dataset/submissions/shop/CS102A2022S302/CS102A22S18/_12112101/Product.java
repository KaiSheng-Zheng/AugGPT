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

    public boolean setRating(int rating) {
        if (rating > 0 && rating < 6) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float averageValue = 0;
        float sum = 0;
        for (Integer rating : ratings) {
            sum = sum + rating;
        }
        if (ratings.size() != 0) {
            averageValue = sum / ratings.size();
        }
        return averageValue;
    }

    public String toString() {
        return "Product ID " + id +
                ", " +
                name +
                ", RMB " +
                String.format("%.2f", price) +
                ", Rating " +
                String.format("%.1f", getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}

