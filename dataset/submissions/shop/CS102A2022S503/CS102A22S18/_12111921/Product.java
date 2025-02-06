import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.price = price;
        this.name = name;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating > 5 || rating < 1){
            return false;
        }
        else {
            ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating(){
        if (this.ratings.size() == 0){
            return 0;
        }
        float a = 0;
        for (int i = 0; i < ratings.size(); i++) {
            a += ratings.get(i);
        }
        return a/ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id, name, price, getAvgRating());

    }


}
