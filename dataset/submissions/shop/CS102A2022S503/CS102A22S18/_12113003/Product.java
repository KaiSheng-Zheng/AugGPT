import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private int PurchaseTime=0;
    private Store belongStore;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        id = ++cnt;
    }

    public boolean setRating(int rating) {
        if (rating > 5 || rating < 1) {
            return false;
        } else {
            ratings.add((Integer) (rating));
            return true;
        }
    }

    public float getAvgRating() {
        float sum = 0;
        if(ratings.size()==0){
            return 0;
        }
        for (int i = 0; i < ratings.size(); i++) {
            sum += (float)(ratings.get(i));
        }
        float avgrating = sum / ratings.size();
        return avgrating;
    }

    public String toString() {
        String subsPrice=String.format("%.2f",price);
        String subsavgRating=String.format("%.1f",getAvgRating());
        return ("Product ID " + id + ", " + name + ", RMB " + subsPrice + ", Rating " + subsavgRating);
    }

    public float getPrice() {
        return price;
    }

    public int getPurchaseTime() {
        return PurchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        PurchaseTime = purchaseTime;
    }

    public Store getBelongStore() {
        return belongStore;
    }

    public void setBelongStore(Store belongStore) {
        this.belongStore = belongStore;
    }
}


