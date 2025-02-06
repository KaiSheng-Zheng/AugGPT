

import java.text.DecimalFormat;
import java.util.ArrayList;

class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (0 < rating && rating < 6) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        DecimalFormat avgRatingFormat = new DecimalFormat("0.0");
        float avgRating = 0;
        if (ratings.size() != 0) {
            for (int rateing : ratings) {
                avgRating += rateing;
            }
            avgRating = avgRating / ratings.size();
            return avgRating;
        } else {
            return 0.0f;
        }
    }

    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat avgRatingFormat = new DecimalFormat("0.0");
        return "Product ID " + id + ", " + name + ", RMB " + priceFormat.format(price) + ", Rating "
                + avgRatingFormat.format(getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Object getName() {
        return name;
    }

}
