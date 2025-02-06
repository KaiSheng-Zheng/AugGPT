import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<Integer>();
    }

    public void setPrice(float pri) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean setRating(int rating) {
        if ( 1 > rating || 5 < rating ) {
            return false;
        }
        else {
            this.ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating() {
        float sum = 0;
        if (sum == 0) {
            return 0;
        }
        else for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return (sum / this.id);
    }

    @Override
    public String toString() {
        return "Product ID " +id+", "+name+", RMB " +price+", Rating " +ratings;
    }
}
