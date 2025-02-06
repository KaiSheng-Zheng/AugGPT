import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public Product(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public float getAvgRating() {
        int sum = 0;
        float ave;
        for (Integer rating : ratings) {
            sum += rating;
        }
        if (ratings.size() == 0) ave = 0;
        else {
            ave = (float) sum / ratings.size();
        }
        return ave;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, getPrice(), getAvgRating());
    }
}
