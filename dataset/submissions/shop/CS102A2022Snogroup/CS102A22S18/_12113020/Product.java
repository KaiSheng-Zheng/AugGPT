import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();

        Product.cnt++;
        this.id = Product.cnt;
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        if (this.ratings.isEmpty())
            return 0f;
        int sum = 0;
        for (int value : this.ratings)
            sum += value;
        return (float)sum / this.ratings.size();
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                this.id, this.name, this.price, getAvgRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
