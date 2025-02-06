import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private boolean purchased = false;
    private int purchaseTime = 0;
    private Store originalStore = null;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        int totalRating = 0;
        for (int i = 0; i < ratings.size(); i++) {
            totalRating += ratings.get(i);
        }
        return (float)totalRating / (float)ratings.size();
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public Store getOriginalStore() {
        return originalStore;
    }

    public void setOriginalStore(Store originalStore) {
        this.originalStore = originalStore;
    }

    public void setPurchaseTime(int purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getPurchaseTime() {
        return purchaseTime;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product ID " + id + ", ");
        stringBuilder.append(name + ", ");
        stringBuilder.append("RMB " + String.format("%.2f", price) + ", ");
        stringBuilder.append("Rating " + String.format("%.1f", getAvgRating()));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Product product = new Product("Laptop", 10000);
        product.setRating(4);
        product.setRating(5);
        product.setRating(5);
        System.out.print(product);
    }
}
