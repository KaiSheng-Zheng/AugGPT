import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        int sum = 0;
        int count = 0;
        if (ratings.size()!=0) {
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += this.ratings.get(i);
                count++;
            }
            return (float) sum / count;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        BigDecimal b1 = new BigDecimal(price);
        double newPrice = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal b2 = new BigDecimal(getAvgRating());
        double newAvg = b2.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, newPrice, newAvg);
    }

    public static void main(String[] args) {
        Product product = new Product("apple", 21);
        product.setRating(1);
        System.out.println(product);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
