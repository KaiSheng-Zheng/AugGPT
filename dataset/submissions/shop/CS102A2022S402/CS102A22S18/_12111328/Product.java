import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
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
        float c = 0;
        float total = 0;
        for (Integer rating : ratings) {
            total = total + rating;
        }
        if (ratings.size() > 0) {
            c = total / ratings.size();
            return total / ratings.size();
        } else {
            return 0;
        }
    }
    public String toString(){
        return  String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
