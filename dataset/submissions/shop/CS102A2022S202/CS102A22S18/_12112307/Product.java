import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = 0;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        } return false;
    }

    public float getAvgRating() {
        float sum = 0;
        if (ratings.size() == 0){
            return 0;
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            float average = sum / ratings.size();
            return average;
        }
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }
}