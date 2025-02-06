import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private int addTime;
    private ArrayList<Integer> ratings;
    private Store store;
    public Product(String name, float price) {
        ratings=new ArrayList<>();
        id=++cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating) {
        if(rating<1||rating>5) return false;
        ratings.add(rating);
        return true;
    }
    public float getAvgRating() {
        int size=ratings.size();
        if(size == 0) return 0;
        double tot=0;
        for(int i=0;i<size;i++)
            tot += ratings.get(i);
        double ans = tot / (double)size;
        return (float)ans;
    }
    public void setAddTime(int addTime) { this.addTime = addTime; }
    public float getPrice() {return price;}
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getAddTime() {
        return addTime;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    @Override
    public String toString() {
        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f",price)
                + ", Rating " + String.format("%.1f",getAvgRating());
    }
}
