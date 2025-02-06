
import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private float average;
    private int storeID;
    public Product (String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;

    }
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }
    public float getAvgRating(){
        float average=0;
        if(ratings.size()==0){
            average=0;
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                average += ratings.get(i);
            }
            average=average/ratings.size();
        }
        return average;
    }
    public String toString(){
        return "Product ID "+id+", "+name+", "+"RMB "+String.format("%.2f",getPrice())+ ", Rating "+String.format("%.1f",getAvgRating());
    }
    public int getId() {return id;}
    public int getStoreID(){return storeID;}

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public float getPrice() {return price;}
}
