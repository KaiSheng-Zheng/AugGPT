import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private final int id;
    private final String name;
    private final float price;
    private final ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        ++cnt;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5)
            return false;
        ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        if (ratings.size() == 0)
            return 0;

        int rateSum = 0;
        for (Integer rating : ratings) {
            rateSum += rating;
        }
        return (float) rateSum / ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                id, name, price, getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
