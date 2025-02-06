import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store from;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        boolean sr;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            sr = true;
            ratings.add(rating);
        } else {
            sr = false;
        }
        return sr;
    }

    public float getAvgRating() {
        int n = ratings.size();
        int sum = 0;
        if (n==0){
            return 0;
        }
        for (int i = 0; i < n; i++) {
            sum = sum + ratings.get(i);
        }
        float avg = (float) sum / n;
        return avg;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        BigDecimal pric = new BigDecimal(price);
        pric = pric.setScale(2, RoundingMode.HALF_UP);
        BigDecimal gtag = new BigDecimal(getAvgRating());
        gtag = gtag.setScale(1, RoundingMode.HALF_UP);
        String str = "Product ID " + getId() + ", " + getName() + ", RMB " + pric + ", Rating " + gtag;
        return str;
    }

    public void setFrom(Store from) {
        this.from = from;
    }
    public Store getfrom() {
        return from;
    }
}
