import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if (this.ratings.size() == 0){
            return 0f;
        }else {
            float a = 0f;
            for (int i = 0; i < this.ratings.size(); i++) {
                a += this.ratings.get(i);
            }
            return a / this.ratings.size();
        }
    }

    @Override
    public String toString(){
        float roundedPrice = Math.round(this.price * 100f) / 100f;
        float roundedRating = Math.round(this.getAvgRating() * 10f) / 10f;
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, roundedPrice, roundedRating);
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}