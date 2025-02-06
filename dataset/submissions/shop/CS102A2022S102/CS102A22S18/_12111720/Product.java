import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;

    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size() != 0) {
            float sum = 0;
            for (int i : ratings) {
                sum += i;
            }
            return sum/ratings.size();
        }else {
            return (float) 0;
        }
    }

    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        String p = decimalFormat.format(price);
        float avg = (float) Math.round(getAvgRating()*10)/10;
        return "Product ID " + id + ", " + name + ", " + "RMB " + p + ", " + "Rating " + avg;
    }
}
