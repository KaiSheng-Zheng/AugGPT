import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>(); // ratings from different customers; default is empty.
    private float ratingSum = 0;


    public int getId() {
        return id;
    }


    public float getPrice() {
        return price;
    }


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;

    }

    public boolean setRating(int rating) {

        if (1 <= rating && rating <= 5) {
            ratings.add(rating);
            ratingSum += rating;
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        return ratingSum == 0 ? 0 : ratingSum / ratings.size();
    }

    @Override
    public String toString() {
        String str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f"
                , id, name, Math.round(price * 100) * 0.01, Math.round(getAvgRating() * 10) * 0.1);
        return str;
    }


}