import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings= new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=Product.cnt;
    }

    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            return this.ratings.add(rating);
        }
        else return false;
    }

    public float getAvgRating(){
        float sum=0;
        float average;
        if (ratings.size()==0){
            return 0.0f;
        }
        else {
            for (int i=0;i<ratings.size();i++){
                sum+=ratings.get(i);
            }
            return (sum/ratings.size());
        }
    }

    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        String str="Product ID "+id+", "+name+", RMB "+priceFormat.format(price)+", Rating " +averageRatingFormat.format(getAvgRating());
        return str;
    }

    public float getPrice(){
        return this.price;
    }

    public int getId(){
        return this.id;
    }
}