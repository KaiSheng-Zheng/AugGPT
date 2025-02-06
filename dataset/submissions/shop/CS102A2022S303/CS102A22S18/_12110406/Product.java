import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float AvgRating = 0;
        if (ratings.size() == 0) {
            return AvgRating;
        } else {
        for (int i = 0; i < ratings.size(); i++) {
            AvgRating = AvgRating + ratings.get(i);
        }
        AvgRating = AvgRating / ratings.size();
        return AvgRating;
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}

