import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int rating_times;
    private int tot_rating;
    private int buyTime;
    private Store belongStore;

    public Product(String name, float price) {
        id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if(rating >=1 && rating <= 5) {
            ratings.add((Integer) rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating() {
        tot_rating = 0;
        rating_times = ratings.size();
        for(Integer integer : ratings) {
            tot_rating += (int)integer;
        }
        if(rating_times == 0) return 0f;
        return (float)((float)tot_rating/rating_times);
    }

    public String toString() {
//        BigDecimal b = new BigDecimal(price);
//        double price1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
//
//        BigDecimal b2 = new BigDecimal(getAvgRating());
//        double avgRating = b2.setScale(1,RoundingMode.HALF_UP).doubleValue();

        String price1 = String.format("%.2f",price);
        String avgRating = String.format("%.1f",getAvgRating());


        return ("Product ID " + id+", " + name +',' +" RMB " + price1 + ',' + " Rating " + avgRating);
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(int buyTime) {
        this.buyTime = buyTime;
    }

    public Store getBelongStore() {
        return belongStore;
    }

    public void setBelongStore(Store belongStore) {
        this.belongStore = belongStore;
    }
}
