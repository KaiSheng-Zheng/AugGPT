import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = 0;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;


    public Product(String name, float price) {
        ratings = new ArrayList<>();
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if( rating <= 5  && rating >= 1) {
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float avgRating = 0;
        if (ratings.size()==0)return 0;
        for (int i = 0; i < ratings.size(); i++) {
            avgRating += ratings.get(i);
        }
        return avgRating/ratings.size();
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f"
                ,this.id,this.name,this.price,getAvgRating());
    }
}