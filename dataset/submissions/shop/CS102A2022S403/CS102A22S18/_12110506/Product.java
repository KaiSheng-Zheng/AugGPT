import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
        ratings = new ArrayList<>();
    }

    public float getPrice() {
        return (float) Math.round(100 * price) / 100;
    }

    public boolean setRating(int rating) {

        if (rating < 1 | rating > 5)
            return false;
        else {
            ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating() {
        float average = 0;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++)
                average += ratings.get(i);
            return  average/(float) ratings.size();
        } else return 0;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, getPrice(), getAvgRating());
    }
}
