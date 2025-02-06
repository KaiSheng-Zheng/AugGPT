import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt. private String name;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt+=1;
        id=cnt;//--------------????
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean setRating(int rating){
        if(rating>=1 && rating<=5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        float sum=0;
        if(ratings.size()==0){
            return 0;
        }else{
        for( int i=0 ; i<ratings.size() ; i++){
            sum+=ratings.get(i);
        }
        return sum/ratings.size();
        }
    }
    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        String afterPrice;
        String afterRating;
        //        if(price-Float.parseFloat(priceFormat.format(price)) >= 0.005f ){
        //            afterPrice = Float.parseFloat(priceFormat.format(price)) + 0.01f;
        //        }else{
        //            afterPrice = Float.parseFloat(priceFormat.format(price));
        //        }
        //        if(getAvgRating()-Float.parseFloat(averageRatingFormat.format(getAvgRating()) )>=0.05f){
        //            afterRating = Float.parseFloat(averageRatingFormat.format(getAvgRating()) )+ 0.1f;
        //        }else{
        //            afterRating = Float.parseFloat(averageRatingFormat.format(getAvgRating()) );
        //        }
        if(price==0){
            afterPrice="0.00";
        }else{
            afterPrice=priceFormat.format(price);
        }
        if(getAvgRating()==0){
            afterRating="0.0";
        }else{
            afterRating=averageRatingFormat.format(getAvgRating());
        }

        String description = "Product ID "+id+", "+name+", RMB "+afterPrice+", Rating "+afterRating;
        return description;
    }
    public float getPrice(){
    return price;
    }
    public String getName(){return name;}
    public int getId(){return id;}



}
