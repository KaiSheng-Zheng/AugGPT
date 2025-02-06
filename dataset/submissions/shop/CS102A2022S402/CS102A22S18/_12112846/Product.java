import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    float sumRating = 0;
    private ArrayList<Integer> ratings;


    public Product(String name, float price) {
        cnt += 1;
        this.name = name;
        this.price = price;
        this.id = Product.cnt;
        ratings=new ArrayList<>();
    }
    
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5 ) {
            sumRating += rating;
            return ratings.add(rating);
        }else {
            return false;
        }

    }
    
    public float getAvgRating() {
        if (ratings.size() == 0) {return 0.0f;}

        for (int integer : this.ratings) {
        }
        return sumRating/this.ratings.size();
    }
    
    public float getPrice() {
        return this.price;
    }


    @Override
    public String toString() {
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        DecimalFormat priceFormat = new DecimalFormat("0.00");

        String output = "Product ID " + this.id + ", " + this.name + ", RMB " + priceFormat.format(this.price) + ", Rating ";
        if (ratings.size() == 0) {
            output += "0.0";
        } else {output += averageRatingFormat.format(this.getAvgRating());}
        return output;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){return true;}
        if(o==null||getClass()!=o.getClass()){return false;}
        Product p=(Product)o;
        return id==p.id;
    }



}
