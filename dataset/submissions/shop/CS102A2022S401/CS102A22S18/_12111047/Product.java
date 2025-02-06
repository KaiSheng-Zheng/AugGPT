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
        this.ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        float sumRating = 0.0f;
        for (Integer integer : this.ratings) {
            sumRating += integer;
        }
        return sumRating/this.ratings.size();
    }

    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        return "Product ID " + this.id
                + ", " + this.name
                + ", RMB " + priceFormat.format(this.price)
                + ", Rating " + averageRatingFormat.format(this.getAvgRating());
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        } else {
            Product product = (Product) o;
            return product.id == this.id;
        }
    }

    public float getPrice() {
        return this.price;
    }

}
