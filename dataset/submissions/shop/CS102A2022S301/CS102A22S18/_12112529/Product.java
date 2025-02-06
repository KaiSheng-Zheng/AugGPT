import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt = cnt + 1;
        id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 & rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }
    public float getAvgRating(){
        float a = 0;
        float A;
        if (ratings.size() == 0){
            A = 0;
            return A;
        }
        for (Integer rating : ratings) {
            a = a + rating;
        }
        A = a/ratings.size();
        return A;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}