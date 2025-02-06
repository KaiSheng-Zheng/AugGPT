import java.util.ArrayList;
import java.util.Comparator;
public class Product{
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        Product.cnt++;
        id = Product.cnt;
    }
    public boolean setRating(int rating){
        if(rating >= 1&& rating <=5){
            this.ratings.add(rating);
            return true;
        }
        else
            return false;
    }
    public float getAvgRating(){
        if(ratings.size() == 0)
            return 0.0f;
        float count = this.ratings.size();
        float total = 0;
        for(int i = 0;i < ratings.size(); i++){
            total += ratings.get(i);
        }
        return total/count;
    }
    public String toString(){
        String output =String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,this.getAvgRating());
        return output;
    }
    public float getPrice(){
        return price;
    }

}
