import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Product {

    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name,float price){
        Product.cnt++;
        this.name=name;
        this.price =price;
        this.id =cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating <1||rating>5){
            return false;
        }else{
            this.ratings.add(rating);
            return  true;
        }
    }

    public float getAvgRating(){
        if(this.ratings.size()==0) return 0.0f;
        else{float sum=0;
        for(int a : this.ratings){
            sum += a;
        }
        return sum/this.ratings.size();}
    }
    public float getPrice(){
        return price;
    }
    @Override
    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        String result = "Product ID "+this.id+", "+this.name+", RMB "+ priceFormat.format(this.price)+", Rating ";
        if(this.ratings.size()==0){
            result += "0.0";
        } else {
            result += averageRatingFormat.format(this.getAvgRating());
        }
        return result;
    }
    @Override
    public boolean equals(Object o){
        if(o.getClass()!=this.getClass()){
            return false;
        }else{
            Product product = (Product) o;
            return product.id == this.id;
        }
    }
}