import java.util.ArrayList;
import java.util.Formatter;

public class Product {
    private float avg = 0;
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;

    public static String format0(double price) {
        return new Formatter().format("%.2f", price).toString();
    }

    private ArrayList<Integer> ratings;

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        cnt = cnt + 1;
        this.id = 1;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRatings(int ratings) {
        if (ratings < 6 && ratings > 0) {
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRatings() {
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.size();
            avg = sum / ratings.size();
        }
        return 0;
    }
    public static String format5(double avg) {
        return new Formatter().format("%.1f", avg).toString();
        }
        public String toString() {
        String str=null;
        str=String.format("%d",id);
        System.out.println(str);
        str=String.format("%f",price);
        str=String.format("%f",avg);
        return name;
    }
}