import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private float Sum;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean checkEquality(Product product){
        if (this.id==product.getId()){
            return true;
        }
        return false;
    }

    public boolean setRating(int rating) {
        if (rating>= 1&&rating<=5){
            Sum += rating;
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        if (Sum==0)
        return 0;
        else return Sum / ratings.size();
    }

     public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }

}
