
import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        if(ratings.isEmpty()) {
            return 0;
        }
        float sum = 0;
        int count = 0;
        for(int i = 0; i < ratings.size(); i++){
            sum += ratings.get(i);
            count++;
        }
        return sum/count;
    }

    public String toString(){
        return String.format("%s %d, %s, %s %.2f, %s %.1f",
                "Product ID", this.id,
                this.name,
                "RMB", this.price,
                "Rating", getAvgRating());

    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public static int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
