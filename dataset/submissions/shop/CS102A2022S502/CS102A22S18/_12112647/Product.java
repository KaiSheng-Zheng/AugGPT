import java.util.ArrayList;


public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    public Store sstore;

    public Product(String name, float price) {
        ++cnt;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        int m = ratings.size();
        if(m==0)
            return 0;
        float sum = 0;
        for (int i = 0; i < m; i++) {
            sum += ratings.get(i);
        }
        return sum / m;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public int getPurchasetime() {
        return cnt;
    }
}
