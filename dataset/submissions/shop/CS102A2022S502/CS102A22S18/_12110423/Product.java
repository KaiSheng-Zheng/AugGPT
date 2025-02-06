import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        Product.cnt++;
        this.id = Product.cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5){
            return this.ratings.add(rating);
        }
        return false;
    }

    public float getAvgRating() {
        if (this.ratings.size() == 0){
            return 0.0f;
        }
        float sum = 0;
        for (int i = 0; i <this.ratings.size(); i++) {
            sum += this.ratings.get(i);
        }
        return sum/this.ratings.size();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String description = "Product ID " + this.id + ", " + this.name + ", RMB " + String.format("%.2f", this.price) + ", Rating ";
        if (this.ratings.size() == 0){
            description += 0.0;
        }else {
            description += String.format("%.1f", this.getAvgRating());
        }
        return description;
    }

}
