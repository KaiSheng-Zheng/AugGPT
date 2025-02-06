import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    private float averageRating;
    private int StoreId;

    public Product(String name, float price){
        cnt += 1;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating<1||rating>5){
            return false;
        }
        else {ratings.add(rating);
        return true;}
    }

    public float getAvgRating(){
        float avgRating = 0;
        if (ratings.isEmpty()){
            this.averageRating = avgRating;
            return 0;
        }
        for (Integer rating : ratings) {
            avgRating += rating;
        }
        avgRating = avgRating /ratings.size();
        this.averageRating = avgRating;
        return avgRating;

    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
//    Return a string description of this product, in the format of Product ID id, name, RMB price, Rating
//    average-rating, e.g., Product ID 12345, Laptop, RMB 10000.00, Rating 4.5.
}
