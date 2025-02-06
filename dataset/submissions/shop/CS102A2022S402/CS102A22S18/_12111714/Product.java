import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store latestStore;

    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            this.ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0;
        if(ratings.size()>0){
            for(int i:this.ratings){
                sum = sum + i;
            }
            return sum/ratings.size();
        }
        else{
            return 0;
        }
    }
    public String toString(){
        return "Product ID " + this.id + ", " + this.name +
                ", RMB " + String.format("%.2f",this.price) + ", Rating " + String.format("%.1f",this.getAvgRating());
    }

    public void setLatestStore(Store store){
        this.latestStore = store;
    }

    public Store getLatestStore() {
        return latestStore;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getCnt() {
        return cnt;
    }

    public float getPrice() {
        return price;
    }
}
