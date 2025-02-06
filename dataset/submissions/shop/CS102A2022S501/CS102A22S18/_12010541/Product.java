import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    Store store;
    private ArrayList<Integer> ratings = new ArrayList<>();

    private long rateSum = 0;

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            this.ratings.add(rating);
            rateSum += (long)rating;
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0.0f;
        }else {
            float ave = (float)rateSum / (float)ratings.size();
            return ave;
        }
    }

    public String toString() {
        String str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
        return str;
    }

    public static void main(String[] args) {
        Product product = new Product("test", 1.25f);
        product.setRating(2);
        product.setRating(1);
        System.out.println(product);
        Product product2 = new Product("test2", 1.888f);
        product2.setRating(5);
        product2.setRating(1);
        System.out.println(product2);
    }
}
