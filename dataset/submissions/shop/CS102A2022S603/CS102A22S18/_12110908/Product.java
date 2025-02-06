import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private float SumRating;
    public Product(String name, float price){
        this.name = name; this.price = price;ratings=new ArrayList<>();
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            ratings.add(rating);
            SumRating = SumRating + rating;
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (SumRating == 0){
            return 0;
        }else {
            return SumRating / ratings.size();
        }
    }
    public int getID(){return id;}
    public float getPrice(){return price;}
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
