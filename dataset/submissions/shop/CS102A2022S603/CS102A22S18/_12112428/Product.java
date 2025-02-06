import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;


public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store store;
    private Date purcheTime;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.id = ++cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating>=1 && rating<=5){
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        if(ratings.size()==0) return 0;
        float avg = 0;
        for(Integer rate: ratings){
           avg += rate; 
        }
        return avg / ratings.size();
    }

    public String toString(){
        DecimalFormat df1 = new DecimalFormat("#0.00");
        DecimalFormat df2 = new DecimalFormat("#0.0");
        return "Product ID "+id+", "+name+", RMB "+df1.format(price)+", Rating "+df2.format(getAvgRating());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getPurcheTime() {
        return purcheTime;
    }

    public void setPurcheTime(Date purcheTime) {
        this.purcheTime = purcheTime;
    }
}
