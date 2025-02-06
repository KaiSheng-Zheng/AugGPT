import java.util.ArrayList;


public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
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

    public void setRatings(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
        }
    }

    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;

    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else
            return false;
    }

    public float getAvgRating() {
        float sum = 0f, avg = 0f;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        if (ratings.size() != 0) {
            avg = sum / ratings.size();
        } else {
            avg = 0;
        }
        return avg;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.getId(), this.getName(), this.getPrice(), this.getAvgRating());
    }

}