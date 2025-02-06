import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public static int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public float getAvgRating() {
        float totalRating = 0;
        float avgRating;
        if (ratings.size() == 0) {
            avgRating = 0;
        }else {
        for (int i = 0; i < ratings.size(); i++) {
            totalRating += ratings.get(i);
        }
        avgRating = totalRating / ratings.size();}
        return avgRating;
    }

    @Override
    public String toString() {
        String s=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return s;
    }
}
