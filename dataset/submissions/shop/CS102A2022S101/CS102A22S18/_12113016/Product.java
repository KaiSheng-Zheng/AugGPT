import java.util.ArrayList;

public class Product {


    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private Store belongStore;

    public Store getBelongStore() {
        return belongStore;
    }

    public void setBelongStore(Store belongStore) {
        this.belongStore = belongStore;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        int sum = 0;

        for (int i : this.ratings) {
            sum += i;
        }

        float average = 0;
        if (this.ratings.size() != 0) {
            average = (float) sum / (float) this.ratings.size();//ratingSize=0 have not been considered;
        }

        float averageRating = average;
        return average;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String priceS = String.format("%.2f", price);
        String aRatingS = String.format("%.1f", getAvgRating());

        return "Product ID " + id + ", " + name + ", RMB " + priceS + ", Rating " + aRatingS;
    }

    public float getPrice() {
        return price;
    }
}