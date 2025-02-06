import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        setId(cnt);
    }

    public boolean setRating(int rating){
        if(rating == 1 || rating == 2 || rating == 3|| rating == 4 || rating == 5){
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating(){
        float rating = 0;
        if(ratings.size()==0){
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                rating = rating + ratings.get(i);
            }
            return rating/ratings.size();
        }
    }
@Override
    public String toString(){
        String str = String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",getId(),this.name, getPrice(),getAvgRating());
        return str;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int cnt) {
        this.id = Product.cnt;
    }

    public String getName() {
        return name;
    }
}
