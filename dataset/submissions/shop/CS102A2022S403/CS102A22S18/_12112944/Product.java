import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(String name, float price) {
        this.id = cnt + 1;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
        cnt++;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else
            return false;
    }

    public float getAvgRating() {
        if(this.ratings.size()==0){
            return 0.0f;
        }
        float total = 0;
        for (int i = 0; i < ratings.size(); i++) {
            total = this.ratings.get(i) + total;
        }
        return total / ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                this.id, this.name, this.price, this.getAvgRating());
    }
}