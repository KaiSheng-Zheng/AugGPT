import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private Store fromStore;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean equal(Product product) {
        if (this.getId() == product.getId()) {
            return true;
        } else {
            return false;
        }
    }

    public void setFromStore(Store fromStore) {
        this.fromStore = fromStore;
    }

    public Store getFromStore() {
        return fromStore;
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        } else {
            float total = 0;
            for (Integer rating : ratings) {
                total += rating;
            }
            return total / ratings.size();

        }
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        String str1 = "Product ID ";
        String str2 = ", ";
        String str3 = ", RMB ";
        String str4 = ", Rating ";
        return str1.concat(String.valueOf(id)).concat(str2).concat(name).concat(str3).concat(String.format("%.2f", price)).concat(str4).concat(String.format("%.1f", this.getAvgRating()));
    }
}