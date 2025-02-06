import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private int PurchaseTime;
    private Store Belong;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        int sum = 0;
        float avg = 0;
        if (ratings.size() == 0){
            return 0.0f;
        }else {
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += ratings.get(i);
            }
            avg = (float) sum/ratings.size();
            return avg;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public static int getCnt() {
        return cnt;
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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings.add(ratings);
    }

    public void setPurchaseTime(int purchaseTime) {
         this.PurchaseTime = purchaseTime;
    }

    public int getPurchaseTime(){
        return PurchaseTime;
    }

    public Store getBelong() {
        return Belong;
    }

    public void setBelong(Store belong) {
        Belong = belong;
    }
}
