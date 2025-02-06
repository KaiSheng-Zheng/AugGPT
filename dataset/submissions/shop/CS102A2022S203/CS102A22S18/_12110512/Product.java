import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {

    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer>ratings = new ArrayList<>();
    // ratings from different customers; default is empty.


    public Product(String name, float price) {
        Product.cnt += 1;
        this.id = Product.cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating() {
        float sum = 0.0f;
        for (int i = 0; i < ratings.size(); i++)
            sum += ratings.get(i);
        return sum / ratings.size();
    }

    public String toString() {
        DecimalFormat price = new DecimalFormat("0.00");
        DecimalFormat rating = new DecimalFormat("0.0");

        String string;
        string  = "Product ID " + this.id
                + ", " + this.name
                + ", RMB " + price.format(this.price)
                + ", Rating " + rating.format(this.getAvgRating());
        return string;
    }

    public float getPrice() {
        return this.price;
    }
}