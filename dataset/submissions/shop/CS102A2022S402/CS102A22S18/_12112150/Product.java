import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;


    public Product(String name, float price){
        ratings=new ArrayList<>();
        cnt++;
        this.name = name;
       this.price=price;

       this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;}
        else
            return false;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {//
        return ratings;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAvgRating(){
        float sum = 0;
        for (float d :this.ratings)
            sum+=d;
       if (this.ratings.size()!=0){
       float average= sum /(float) this.ratings.size();
       return average;}
       else
           return 0;
    }
public String toString(){
    DecimalFormat d2 = new DecimalFormat("###.00");
    DecimalFormat d1 = new DecimalFormat("###.0");

    if (getAvgRating()!=0)
        return "Product ID "+id+", "+name+", RMB "+d2.format(price)+", Rating "+d1.format(getAvgRating());
    else
        return "Product ID "+id+", "+name+", RMB "+d2.format(price)+", Rating 0.0" ;
    }



}
