import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Store in;

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating) {
        if (rating > 5 || rating < 1) {
            return false;
        } else {
            this.ratings.add(rating);
            return true;
        }
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating() {
        float num;
        int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        if (ratings.size() != 0) {
            num = (float) sum / ratings.size();

        } else {
            num = 0;
        }
        return num;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        BigDecimal a = BigDecimal.valueOf(this.price).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal b = BigDecimal.valueOf(this.getAvgRating()).setScale(1, BigDecimal.ROUND_HALF_EVEN);
//        System.out.println(b);
        return new String("Product ID " + this.id + ", " + this.name + ", RMB "
                + a +
                ", Rating " + b);

    }


}