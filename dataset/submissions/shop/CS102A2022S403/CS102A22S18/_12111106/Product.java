import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating<=5 && rating>=1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        int i=0;
        if(ratings.size()==0){
            return 0;
        }else {
            for (Integer rating : ratings) {
                i = i + rating;
            }
            return (float) (i*1.0 / ratings.size());
        }
    }

    public String toString(){
        return "Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f",this.price)+", Rating "+String.format("%.1f",getAvgRating());
    }

    public float getPrice(){
        return price;
    }
}

