import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        int rateSize = ratings.size();
        float rateSum = 0;

        for (Integer rating : ratings) {
            rateSum = rateSum + rating;
        }

        if (rateSize != 0) {
            return rateSum / rateSize;
        } else {
            return 0;
        }
    }

    public String toString() {
        if (price <= 0){
            if (getAvgRating() <= 0){
                return "Product ID " + id + ", " + name + ", RMB " + price + ", Rating " + getAvgRating();
            } else {
                DecimalFormat df2 = new DecimalFormat("0.0");
                String rateAvg = df2.format(getAvgRating());
                return "Product ID " + id + ", " + name + ", RMB " + price + ", Rating " + rateAvg;
            }
        } else {
            DecimalFormat df1 = new DecimalFormat("0.00");
            String priceNew = df1.format(price);
            if (getAvgRating() <= 0){
                return "Product ID " + id + ", " + name + ", RMB " + priceNew + ", Rating " + getAvgRating();
            } else {
                DecimalFormat df2 = new DecimalFormat("0.0");
                String rateAvg = df2.format(getAvgRating());
                return "Product ID " + id + ", " + name + ", RMB " + priceNew + ", Rating " + rateAvg;
            }
        }
    }

    public float getPrice() {
        return price;
    }
}
