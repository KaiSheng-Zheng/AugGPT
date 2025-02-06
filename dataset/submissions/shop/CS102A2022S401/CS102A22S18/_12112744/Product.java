import java.util.ArrayList;

public class Product {
    //Attributes
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int belongToStore;

    //Constructor
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    //Setters
    public void setBelongToStore(int storeID) {
        belongToStore = storeID;
    }


    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public int getBelongToStore() {
        return belongToStore;
    }


    //Methods
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating() {
        int count = getRatings().size();
        if (count == 0) {
            return 0;
        }
        else {
            int ratingsSum = 0;
            for (int i = 0; i < count; i++) {
                ratingsSum += ratings.get(i);
            }
            return (float) ratingsSum / count;
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", getId(), getName(), getPrice(), getAvgRating());
    }
}
