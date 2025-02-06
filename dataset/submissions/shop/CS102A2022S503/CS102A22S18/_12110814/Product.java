import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each product and the value is set to cnt.
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    int purchaseTime;
    int Id_ofStore_itBelong;


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt ++;
        this.id = cnt;
    }


    public String Name() { return this.name;}
    public int Id() { return this.id;}
    public float Price() { return this.price;}

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            this.ratings.add(rating);
            return true;                //There is no requirement for it, but I add it for grammatical reasonableness.
        }
        else
            return false;
    }

    public float getAvgRating() {
        if (ratings.size() != 0) {
            float avgRating = 0;
            for (int rating : ratings) {
                avgRating += rating;
            }
            avgRating /= ratings.size();
            return avgRating;
        }
        else
            return 0;
    }

    @Override
    public String toString() {
        return  "Product ID " + id +
                ", " + name +
                ", RMB " + changeFigures(price, 2) +
                ", Rating " + changeFigures(getAvgRating(), 1);
    }

    public String changeFigures(float oriFloat, int figures) {
        DecimalFormat decimalFormat = new DecimalFormat("0." + "0".repeat(Math.max(0, figures)));
        return decimalFormat.format(oriFloat);
    }

}
