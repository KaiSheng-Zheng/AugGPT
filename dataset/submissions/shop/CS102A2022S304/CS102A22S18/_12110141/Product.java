import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; defaultis empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0.0f;
        } else {
            float ratehe = 0;
            for (int i = 0; i < ratings.size(); i++) {
                ratehe = ratehe + ratings.get(i);
            }
            return ratehe / ratings.size();
        }
    }
    public  String toString() {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat avgRatingFormat = new DecimalFormat("0.0");
        String s="Product ID "+id+", "+name+", RMB "+priceFormat.format(price)+", Rating "+avgRatingFormat.format(getAvgRating());
        return s;
    }
}
