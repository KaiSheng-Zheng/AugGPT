import java.text.DecimalFormat;
import java.util.ArrayList;


public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }
    public boolean setRating(int rating){
        if(1 <= rating && rating <= 5) {
            ratings.add(rating);
            return true;
        }else
            return false;
    }

    public float getAvgRating(){
        float avg = 0;
        if(ratings.size() != 0) {
            float total = 0;
            for (int i : ratings)
                total += i;
            avg = total / ratings.size();
        }else
            avg = 0;
        return avg;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public Store getStore(){
        return store;
    }

    @Override
    public String toString(){//Round price to 2 decimal places and rating to 1 decimal place
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df1 = new DecimalFormat("0.0");
        String pricenew = df.format(price);
        String avg = df1.format(getAvgRating());
        return "Product ID " + id + ", " + name + ", RMB " + pricenew + ", Rating " + avg;
    }

}
