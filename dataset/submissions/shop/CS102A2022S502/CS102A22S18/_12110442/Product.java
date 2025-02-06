import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            return this.ratings.add(rating);
        }
        return false;
    }

    public float getAvgRating() {
        float avgRating;
        float sum = 0;
        if (this.ratings.size() == 0){
            return sum = 0.0f;
        }
        for (int i = 0; i < this.ratings.size(); i++) {
            sum += this.ratings.get(i);
        }
        avgRating = sum/this.ratings.size();
        return avgRating;
    }

    public String toString() {
        DecimalFormat priceF = new DecimalFormat("0.00");
        DecimalFormat avgF = new DecimalFormat("0.0");
        String productDes = "Product ID "+this.id+", "+this.name+", RMB "+priceF.format(this.price)+", Rating "+avgF.format(this.getAvgRating());
        return productDes;
    }

    public float getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }

}
