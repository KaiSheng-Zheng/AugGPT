import java.util.ArrayList;

public class Product {

    private static int cnt = 0;
    private int id;
    private String name;

    public float getPrice() {
        return price;
    }

    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating >= 1&&rating <= 5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.size() == 0)
            return 0f;
        float t = 0.0f;
        for (int i:ratings){
            t += (float) i;
        }
        return t / ratings.size();
    }

    @Override
    public String toString() {
        return "Product ID " + id + ", "+ name +", RMB " + String.format("%.2f",price) +", Rating " + String.format("%.1f",getAvgRating());
    }
}
