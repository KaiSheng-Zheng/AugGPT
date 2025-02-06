
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public float getPrice(){return price;}

    public boolean setRating(int rating){
        if( rating >= 1 && rating <= 5 ){
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating(){
        float m = 0;
        for (Integer value : ratings) {
            m += value;
        }
        if ( m == 0 )
            return 0;
        else
            return ( m / ratings.size() );
    }

    @Override
    public String toString(){
        String s1 = String.format("Product ID %d, %s, ",id,name);
        String s2 = String.format("RMB %.2f, ",price);
        String s3 = String.format("Rating %.1f",getAvgRating());
        return s1+s2+s3;
    }

}
