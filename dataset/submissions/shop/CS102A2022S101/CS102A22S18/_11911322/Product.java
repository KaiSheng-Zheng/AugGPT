import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int FromStore;
    private int PurchaseTime = 0;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if(rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float sum = 0;
        float counter = 0;
        for (int rating : this.ratings) {
            sum += (float) rating;
            counter += (float) 1;
        }
        float averageRating = 0;
        if (counter != 0) averageRating = sum/counter;
        return averageRating;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getFromStore() {
        return FromStore;
    }

    public void setFromStore(int fromStore) {
        FromStore = fromStore;
    }

    public int getPurchaseTime() {
        return PurchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        PurchaseTime = purchaseTime;
    }
}