import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store sellFrom;

    public Product(String name, float price) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public void setSellFrom(Store sellFrom) {
        this.sellFrom = sellFrom;
    }

    public Store getSellFrom() {
        return sellFrom;
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float sum = 0;
        float num = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int rating : ratings) {
                sum += rating;
                num += 1;
            }
            return sum / num;
        }
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        float price = (float) Math.round(this.price * 100) / 100;
        float rating = (float) Math.round(getAvgRating() * 10) / 10;
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, getPrice(), getAvgRating());
    }
}
