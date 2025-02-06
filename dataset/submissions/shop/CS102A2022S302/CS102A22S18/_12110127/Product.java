import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
        this.id = product.id;

    }

    public boolean setRating(int rating) {
        if (rating == 1) {
            ratings.add(rating);
            return true;
        }
        if (rating == 2) {
            ratings.add(rating);
            return true;
        }
        if (rating == 3) {
            ratings.add(rating);
            return true;
        }
        if (rating == 4) {
            ratings.add(rating);
            return true;
        }
        if (rating == 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        float sum = 0;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return (sum / (float) ratings.size());

        } else return 0.00f;
    }

    public String toString() {
        String s1 = "Product ID %d, %s, RMB %.2f, Rating %.1f";
        return String.format(s1, id, name, price, getAvgRating());
    }
}