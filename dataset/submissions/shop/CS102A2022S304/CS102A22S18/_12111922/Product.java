import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public static int getCnt(){
        return cnt;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating<1||rating>5){
            return false;
        }
        else {
            this.ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        if (this.ratings.size() == 0){
            return 0;
        }
        else {
        float sum = 0;
        for (int i = 0; i<ratings.size();i++){
            sum = sum + ratings.get(i);
        }
        return sum/ratings.size();
        }
    }
    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
