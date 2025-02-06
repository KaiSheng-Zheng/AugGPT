import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        int sum = 0;
        float averageRating ;
        if (ratings.size()==0){
            averageRating =0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
         averageRating = (float) sum / ratings.size();
        }
        return averageRating;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
