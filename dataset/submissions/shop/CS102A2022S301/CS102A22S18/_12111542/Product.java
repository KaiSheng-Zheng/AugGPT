import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    Store sd;

    public Product(String name, float price) {
        this.price = price;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            ratings.add(rating);
            return true;
        }
    }


    public float getAvgRating() {
        float length = ratings.size();
        float total = 0;
        if (length == 0) {
            return 0;
        }
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                total += ratings.get(i);
            }
        }
        float ave = total / length;


        return ave;
    }

    public String toString() {
        DecimalFormat drating = new DecimalFormat("0.0");
        DecimalFormat dprice = new DecimalFormat("0.00");
        String rating2 = drating.format((float) getAvgRating());
        String price2 = dprice.format((float) price);
        return "Product ID " + id + ", " + name + ", " + "RMB " + price2 + ", " + "Rating " + rating2;
    }
}