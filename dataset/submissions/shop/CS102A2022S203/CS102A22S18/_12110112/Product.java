import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private  static  int cnt=0;
    private  int id;
    private String name;
    private  float price;
    private ArrayList<Integer> ratings= new ArrayList<>();
    public Product(String name, float price){
        Product.cnt++;
        this.id=Product.cnt;
        this.name = name;
        this.price = price;
    }
    public  boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            return this.ratings.add(rating);
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        if(this.ratings.size()==0){
            return 0.0f;
        }else {
            float sum=0;
            for (int integer : this.ratings) {
                sum += integer;
            }
            return  (sum/this.ratings.size());
        }
    }
    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        String output = "Product ID " + this.id
                + ", " + this.name
                + ", RMB " + priceFormat.format(this.price)
                + ", Rating "+averageRatingFormat.format(this.getAvgRating());
        return output;
    }
    public float getPrice() {
        return this.price;
    }
}
