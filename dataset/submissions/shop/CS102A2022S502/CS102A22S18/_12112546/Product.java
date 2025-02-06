import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = 0;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
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
        float sum = 0;
        float avg = 0;
        if (ratings.size() == 0){            avg = 0;
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                sum = ratings.get(i) + sum;
                avg = sum / ratings.size();
            }
        }
        return avg;
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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    @Override
    public String toString(){
        String description = "";
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        DecimalFormat df2 = new DecimalFormat("0.0");
        df2.setRoundingMode(RoundingMode.HALF_UP);
        description = description.concat("Product ID ").concat(String.valueOf(this.id)).concat(", ")
                .concat(this.name).concat(", RMB ").concat(df.format(this.price)).concat(", Rating ")
                .concat(df2.format(getAvgRating()));

        return description;
    }

    public float getPrice() {
        return price;
    }
}
