import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        id = 1+cnt;
        cnt++;
        ArrayList<Integer> a = new ArrayList<>();
        ratings = a;
    }
    public boolean setRating(int rating) {
        if ((rating <= 5)&&(rating >= 1)) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }
    public float getAvgRating() {
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += (float)ratings.get(i);
        }
        if (ratings.size() == 0) {
            return 0.0F;
        } else {
            return sum / ratings.size();
        }
    }
    public String toString() {
        String a = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return a;
    }
    public float getPrice() {
        return price;
    }
    public void setRatings(int rate) {
        ratings.add(rate);
    }
}
