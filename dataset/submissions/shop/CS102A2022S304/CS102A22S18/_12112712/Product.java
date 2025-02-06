import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name,float price){
        ratings = new ArrayList<>();
        this.name=name;
        this.price=price;
        cnt++;
        id = cnt;
    }
    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size() != 0) {
            float k = 0;
            for (int i = 0; i < ratings.size(); i++) {
                k += ratings.get(i);
            }
            k = k / ratings.size();
            return k;
        }else {
            return 0;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
