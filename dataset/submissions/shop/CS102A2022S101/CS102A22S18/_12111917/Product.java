import java.util.ArrayList;
import java.util.List;

public class Product {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (List.of(1, 2, 3, 4, 5).contains(rating)) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public float getAvgRating() {
        float sum = 0;
        for (int rate : ratings) {
            sum += rate;
        }
        if (!ratings.isEmpty()) {
            return sum / ratings.size();
        }
        return 0;
    }

    public String toString() {
        String str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                id, name, price, getAvgRating());
        return str;
    }

    public static void main(String[] args) {
        Product p1 = new Product("Apple", (float) 3.8);
        p1.setRating(2);
        System.out.println(p1);
        Product p2 = new Product("Orange", (float) 3.6);
        p2.setRating(3);
        System.out.println(p2);

    }
}
