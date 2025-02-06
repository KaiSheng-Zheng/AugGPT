import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is cal
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt = cnt + 1;
        this.id = cnt;
        ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        this.ratings.add(rating);
        return true;

    }

    public float getAvgRating() {
        float sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        if (ratings.size() == 0) {
            return 0;
        } else {
            return sum / ratings.size();
        }
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        return "Product" + " ID " + id + ", " + name + ", RMB " +
                String.format("%.2f", Math.round(price * 100.0) / 100.0)
                + ", Rating " + String.format("%.1f", Math.round(getAvgRating() * 10.0) / 10.0);
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        if (product.getId() == 0) {
            return false;
        }
        if (id == 0) {
            if (product.getId() != 0) {
                return false;
            }
        } else if (!(id == product.getId())) {
            return false;
        }
        return true;
    }
}
