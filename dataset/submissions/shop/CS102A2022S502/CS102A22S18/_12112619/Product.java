import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private Store belongTo;//used to track where the product lastly bought from

    public Store getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(Store belongTo) {
        this.belongTo = belongTo;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            this.ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating() {
        int sum = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get((i));
            }
            return (float) sum / ratings.size();
        }
    }
    
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }
}
