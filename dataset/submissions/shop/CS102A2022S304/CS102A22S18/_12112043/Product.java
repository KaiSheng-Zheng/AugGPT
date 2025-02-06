import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id  =1;
    private String name;
    private float price;
    public float getPrice() {
        return price;
    }
    private ArrayList<Integer> ratings;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating<1||rating>5){
            return false;
        }else {
            this.ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating() {
        float sum = 0;
        if (ratings.size()==0){
            sum = 0.0f;
            return sum;
        }else {
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += this.ratings.get(i);
            }
            return sum / ratings.size();
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }
}