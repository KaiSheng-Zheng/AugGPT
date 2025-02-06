
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the
    //constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    public int StoreId;
    public static ArrayList<Product> ProductList=new ArrayList<>();

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default

    // is empty.
    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        ProductList.add(this);
    }
    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float average=0;
        if (ratings.size()>0){
            for (int i = 0; i <ratings.size(); i++) {
                average+=ratings.get(i);
            }
            average=average/ratings.size();
        }return average;
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

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
