import java.util.ArrayList;
import static java.lang.String.format;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        cnt++;
        id=cnt;
        this.name = name;
        this.price = price;
        this.ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){this.ratings.add(rating);return true;}else{return false;}
    }
    public float getAvgRating(){
        float sum=0;
        float average;
        if(ratings.size()==0){
            return 0;
        }
        for (Integer rating : ratings) {
            sum += (float)rating;
        }
        average=sum/(float)ratings.size();
        return average;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    // Product ID 12345, Laptop, RMB 10000.00, Rating 4.5
}
