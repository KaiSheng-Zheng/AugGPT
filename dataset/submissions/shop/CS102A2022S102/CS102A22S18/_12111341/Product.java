import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.name = name;this.price = price;
        cnt++;this.id=cnt;
    }


    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        int sum = 0;
        if (ratings.size()==0){
            return 0;
        }else{
            for (Integer rating : ratings) {
                sum = sum + rating;
            }
            return (float)sum/ratings.size();
        }
    }
    public String toString(){
         return  "Product ID "+id+", "+name+", RMB "+
                 (new DecimalFormat("0.00").format(price))+", Rating "+
                 (new DecimalFormat("0.0").format(getAvgRating()));
    }
}
