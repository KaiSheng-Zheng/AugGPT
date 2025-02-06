import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings =new ArrayList<>();
    Store store;

    public void from(Store store){
        this.store=store;
    }
    public static int getCnt() {
        return cnt;
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

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1) {
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0;
        if(ratings.size()!=0){
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        sum=sum/(ratings.size());
        return sum;
        }else{
            return 0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }
}