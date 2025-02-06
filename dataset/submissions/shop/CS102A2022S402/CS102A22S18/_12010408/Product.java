import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        ++cnt;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            this.ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        int n = this.ratings.size();
        if (n == 0) return 0;
        float sum = 0;
        for (Integer rating : this.ratings) sum += rating;
        return sum/n;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

}
