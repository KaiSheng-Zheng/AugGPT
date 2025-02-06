import java.util.ArrayList;

import static java.lang.String.format;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;
//    private int PurchaseTime;
    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
        this.store = null;
//        this.PurchaseTime = 0;
    }
    //setter
    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        this.ratings.add(rating);
        return true;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    //getter
    public float getAvgRating() {
        if (this.ratings.size() == 0) {
            return 0;
        }
        float sum = 0;
        for (int rating : this.ratings) {
            sum += rating;
        }
        return sum / this.ratings.size();
    }
    public String getName() {
        return this.name;
    }
    public Store getStore() {
        return this.store;
    }

    public float getPrice() {
        return this.price;
    }
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }


//    public void setPurchaseTime(int time){
//        this.PurchaseTime = time;
//    }
//    public int getPurchaseTime(){
//        return this.PurchaseTime;
//    }
    //quick sort
}


