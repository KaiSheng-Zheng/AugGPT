import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    protected float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        this.ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        float sum = 0.0f;
        for (Integer i : this.ratings) {
            sum += i;
        }
        return sum / this.ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        return ((Product)o).id == this.id;

    }
}