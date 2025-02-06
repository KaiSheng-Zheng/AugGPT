import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt =0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating>0&&rating<6){
            return this.ratings.add(rating);
        }else
            return false;
    }
    public float getAvgRating(){
        int sum= ratings.stream().mapToInt(rating -> rating).sum();
        if (sum==0){
            return 0.0f;
        }else
            return (float) sum /this.ratings.size();

    }

    @Override
    public String toString() {
        DecimalFormat pr = new DecimalFormat("0.00");
        DecimalFormat av = new DecimalFormat("0.0");
        return "Product ID " + this.id +
                ", " + this.name +
                ", RMB " +pr.format(this.price) +
                ", Rating " + av.format(this.getAvgRating());
    }

    public float getPrice() {
        return this.price;
    }
}