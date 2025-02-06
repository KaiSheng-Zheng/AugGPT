import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float size = ratings.size();
        int sum = 0;
        for(int rating : ratings){
            sum += rating;
        }
        if(sum == 0)
            return 0;
        float avg = sum/size;
        return avg;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
