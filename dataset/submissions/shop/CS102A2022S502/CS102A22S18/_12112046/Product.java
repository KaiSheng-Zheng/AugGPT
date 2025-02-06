import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float sum =0;
        float avg;
        if(this.ratings.size() != 0){
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += this.ratings.get(i);
            }
            avg =  sum / this.ratings.size();
        }else{
            avg = 0.0f;
        }
        return avg;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }
}
