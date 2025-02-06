


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {

    private static DecimalFormat dfPrice = new DecimalFormat("#.00");
    private static DecimalFormat dfRating = new DecimalFormat("#.0");

    private static AtomicInteger count = new AtomicInteger();

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList(); ; // ratings from different customers; default is empty.

    private Store store; //for purchaseProduct or refundProduct

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product(String name, float price){
        count.set(cnt);
        count.incrementAndGet();
        int i = count.get();
        this.id = i;
        cnt = i;

        this.name = name;
        this.price = price;
    }

    /**
     * A rating should be within the range [1,5]; in other words, there are only 5 possible values for rating.
     * If rating is not in this range, do not add it into rating and return false.
     * @param rating
     * @return
     */
    public boolean setRating(int rating){
        if (rating < 1 || rating > 5){
            return false;
        }
        this.ratings.add(rating);
        return true;
    }

    public float getPrice() {
        return price;
    }

    /**
     *Return the average rating of this product, which is computed as the average of all the ratings it has received
     * so far.
     * @return
     */
    public float getAvgRating(){
        if (ratings == null || ratings.size() == 0){
            return 0f;
        }
        double v = ratings.stream().mapToInt(Integer::intValue).average().getAsDouble();

        return (float) v;

    }

    /**
     * Return a string description of this product, in the format of Product ID id, name, RMB price, Rating
     * average-rating, e.g., Product ID 12345, Laptop, RMB 10000.00, Rating 4.5.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Product " +
                "ID " + id +
                ", " + name +
                ", RMB " + (price != 0 ? dfPrice.format(price) : "0.00") +
                ", Rating " + (getAvgRating() != 0 ? dfRating.format(getAvgRating()) : "0.0");
    }


}
