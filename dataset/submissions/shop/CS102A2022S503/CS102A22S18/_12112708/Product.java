import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt = cnt + 1;
        id = cnt;
    }
    public String toString() {
        return "Product ID " + id + ", " + name + ", "
                + "RMB " + String.format("%.2f", getPrice()) + ", "
                + "Rating " + String.format("%.1f", getAvgRating());
    }
    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        float sumRating=0;
        if (ratings.isEmpty()) {
            return 0;}
        else {
            for (int i=0;i<ratings.size();i++) {
                sumRating += ratings.get(i);}
            return ((sumRating) / (ratings.size()));
        }
    }

}