import java.util.ArrayList;

public class Product {
    private static  int cnt =0 ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        int sum = 0;
        for (int i : ratings) {
            sum += i;
        }
        return (float) (sum * 1.0 / ratings.size());
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
