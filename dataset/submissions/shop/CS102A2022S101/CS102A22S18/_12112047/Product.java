import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    float average;


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating() {

        float sum = 0;
        int i;

        for (i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        if (ratings.size() == 0) {
            average = 0;
        }else{
        average = sum / ratings.size();}
        return average;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, average);
    }
}
