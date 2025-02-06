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
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        if (ratings.size() != 0){
            int sum = 0;
            for (Integer rating : ratings) {
                sum += rating;
            }
        return (float) sum/ratings.size();
        }
        else {
            return 0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}