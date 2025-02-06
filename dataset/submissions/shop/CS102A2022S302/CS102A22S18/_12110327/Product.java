import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {

    private static int cnt = 0;

    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        Product.cnt++;
        this.name = name;
        this.price = price;
        this.id = Product.cnt;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        return this.ratings.add(rating);
    }

    public float getAvgRating() {
        if (this.ratings.size() == 0){
            return 0;
        }
        float sum = 0;
        for (int integer : this.ratings) {
            sum += integer;
        }
        return sum/this.ratings.size();
    }

    @Override
    public String toString() {
        DecimalFormat prFormat = new DecimalFormat("0.00");
        DecimalFormat rFormat = new DecimalFormat("0.0");
        String output = "Product ID " + this.id
                + ", " + this.name
                + ", RMB " + prFormat.format(this.price)
                + ", Rating ";
        if (this.ratings.size() == 0) {
            output = output + "0.0";
        } else {
            output = output + rFormat.format(this.getAvgRating());
        }
        return output;
    }

    @Override
    public boolean equals(Object t) {
        if (t.getClass() != this.getClass()) {
            return false;
        } else {
            Product product = (Product) t;
            return product.id == this.id;
        }
    }

    public float getPrice() {
        return this.price;
    }
}