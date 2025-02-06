import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private ArrayList<Integer> Ratings;

    public Product(String name, float price) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.price = price;
        this.ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) sum += ratings.get(i);
        return sum / ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int order;
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public float getPrice() {
        return price;
    }
}
