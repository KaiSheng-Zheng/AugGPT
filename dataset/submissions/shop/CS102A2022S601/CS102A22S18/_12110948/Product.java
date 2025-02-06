import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings =new ArrayList<>();

    public Product(String name, float price) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            this.ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        float sum = 0;
        if(ratings.size() == 0){
            return 0;
        }
        for (int i = 0;i < ratings.size();i++) {
            sum = sum + ratings.get(i);
        }
        return (sum / ratings.size());
    }

    public String toString() {
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f" , getId(), getName() , getPrice() , getAvgRating());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price %.2f;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}
