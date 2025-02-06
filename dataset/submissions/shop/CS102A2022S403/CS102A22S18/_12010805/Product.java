import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private int storeId = 0;
    private int time = 0;
    private int rid = 0;
    private float rt;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }
    public int getTime() {
        return time;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;

    }
    public boolean setRating(int rating){
        if (rating > 0 && rating < 6)
        {
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        rt = 0f;
        for (int i = 0; i < ratings.size(); i++)
            rt += ratings.get(i);
        if (ratings.size() == 0)
            return 0f;
        else return rt/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}

class  ProductTimeComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2){
        if (p1.getTime() > p2.getTime())
            return 1;
        else if (p1.getTime() < p2.getTime())
            return -1;
        else return 0;
    }
}
class  ProductRatingComparator implements Comparator<Product> {

    public int compare(Product p1, Product p2){
        if (p1.getAvgRating() > p2.getAvgRating())
            return 1;
        else if (p1.getAvgRating() < p2.getAvgRating())
            return -1;
        else {
            if (p1.getTime() > p2.getTime())
                return 1;
            else if (p1.getTime() < p2.getTime())
                return -1;
            else return 0;
        }

    }
}
class  ProductPriceComparator implements Comparator<Product> {

    public int compare(Product p1, Product p2){
        if (p1.getPrice() > p2.getPrice())
            return 1;
        else if (p1.getPrice() < p2.getPrice())
            return -1;
        else {
            if (p1.getTime() > p2.getTime())
                return 1;
            else if (p1.getTime() < p2.getTime())
                return -1;
            else return 0;
        }

    }
}