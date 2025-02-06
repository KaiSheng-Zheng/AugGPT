import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
        this.ratings=new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating() {
        float sum = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return sum / ratings.size();
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public float getPrice() {
        return price;
    }
    public String getName() {return name;}
    public int getId() {
        return id;
    }
}
