import java.text.DecimalFormat;
import java.util.*;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating<=5&&rating>=1) {
            return this.ratings.add(rating);
        } else
            return false;
    }

    public float getAvgRating() {
        if(this.ratings.size()==0)
            return 0.0f;
        float sum = 0.0f;
        for (int n : this.ratings)
            sum += n;
        return sum/this.ratings.size();
    }
    public float getPrice(){
        return this.price;
    }
    @Override
    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        String ret="Product ID "+this.id+", "+this.name+", RMB "+priceFormat.format(this.price)+", Rating ";
        if(this.ratings.size()==0)
        {ret+="0.0";}
        else
        {ret+=averageRatingFormat.format(this.getAvgRating());}
        return ret;
    }
    @Override
    public boolean equals(Object obj){
        if(obj.getClass()!=this.getClass()){
            return false;
        }
        else{
         Product product=(Product) obj;
        return product.id==this.id;
        }
    }

}
