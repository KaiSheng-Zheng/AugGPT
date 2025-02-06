
import java.util.ArrayList;
public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(){}
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if(rating <=5&&rating>=1) {
            this.ratings.add(rating);
            return true;
        }
        else {
            return false;

        }
    }
    public float getPrice() {
        return price;
    }
    public float getAvgRating() {
        float all = 0;
        for (Integer rating : this.ratings) {
            all += rating;
        }
        if (this.ratings.size()!= 0) {
            return all / this.ratings.size();
        }
        else{
            return  0 ;
        }
    }
    public String toString(){
        return "Product ID " + this.id + ", " + this.name + ", RMB "
                +String.format("%.2f",(float) Math.round(getPrice()*100)/100f)+
                ", Rating " + String.format("%.1f",Math.round(getAvgRating()*10)/10f);
    }
}
