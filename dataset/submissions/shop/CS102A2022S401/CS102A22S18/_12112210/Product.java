import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>(); // ratings from different customers; default is empty.
    private int storeId;
    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;

    }
    public boolean setRating(int rating){
        if(rating > 0 && rating < 6){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        float sum = 0;
        if(ratings.size() == 0){
            return sum;
        }
        for(int i : ratings){
            sum += i;
        }
        return sum/ratings.size();
    }

    public int getId() {
        return id;
    }
    public float getPrice(){
        return price;
    }

    public int getStoreId(){
        return storeId;
    }
    public void setStoreId(int storeId){
        this.storeId = storeId;
    }
    public String toString(){
        StringBuilder str = new StringBuilder("Product ID ");
        DecimalFormat one = new DecimalFormat(".0");
        String ratingInOne = one.format(getAvgRating());
        DecimalFormat Two = new DecimalFormat(".00");
        String priceInTwo = Two.format(getPrice());
        str.append(id);
        str.append(", ");
        str.append(name);
        str.append(", ");
        str.append("RMB "+priceInTwo);
        str.append(", ");
        if(getAvgRating() != 0){
            str.append("Rating "+ratingInOne);
        }else{
            str.append("Rating 0.0");
        }

        return str.toString();
    }
}
