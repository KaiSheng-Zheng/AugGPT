import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    /**
     * A rating should be within the range [1,5]; in other words,
     * there are only 5 possible values for rating.
     * If rating is not in this range, do not add it into rating and return false.
     *
     * @param rating
     * @return
     */
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return the average rating of this product,
     * which is computed as the average of all the ratings it has received so far.
     * Round the return value to 1 decimal place.
     *
     * @return
     */
    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        }
        float sum = 0;
        for (float r : ratings
        ) {
            sum += r;
        }
        return sum / ratings.size();
    }


    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }

    public static int getCnt() {
        return cnt;
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


}
